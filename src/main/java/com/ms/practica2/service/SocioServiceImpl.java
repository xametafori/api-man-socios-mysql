package com.ms.practica2.service;

import com.ms.practica2.model.SocioMongoDb;
import com.ms.practica2.model.SocioMysql;
import com.ms.practica2.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service("serviceRestTemplate")
public class SocioServiceImpl implements SocioService{

    @Autowired
    SocioRepository repositorio;

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public SocioMysql save( String dni, String estado) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("dni", dni);
       SocioMongoDb socioMongoDbs = clienteRest.getForObject("http://api-man-socios-mongodb-p2:8092/socio/{dni}", SocioMongoDb.class, pathVariables);
        SocioMysql socioMysql = new SocioMysql();

        if(socioMongoDbs!= null){
            socioMongoDbs.setEstado(estado.toUpperCase().equals("ACTIVO") ?1:0);
            actualizarSocio(socioMongoDbs);
            String fecha= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
            socioMysql.setDni(dni);
            socioMysql.setEstado(estado);
            socioMysql.setFecha(fecha);
            actualizarHistorialAuditoriaSocio(socioMysql);
        }

        return socioMysql;
    }

    private void actualizarSocio(SocioMongoDb socioMongoDbs){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://api-man-socios-mongodb-p2:8092/socio/".concat(socioMongoDbs.getDni()));
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<SocioMongoDb> request = new HttpEntity<>(socioMongoDbs, headers);
         clienteRest.exchange(builder.toUriString(), HttpMethod.PUT, request, SocioMongoDb.class)
                .getBody();
    }

    private void actualizarHistorialAuditoriaSocio(SocioMysql socioMysql){
        repositorio.save(socioMysql);
    }
}
