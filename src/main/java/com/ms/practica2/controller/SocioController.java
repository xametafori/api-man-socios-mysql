package com.ms.practica2.controller;

import com.ms.practica2.model.SocioMysql;
import com.ms.practica2.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SocioController {

    @Autowired
    SocioService servicio;

    @PutMapping("/socio/{dni}/{estado}")
    @ResponseStatus(HttpStatus.OK)
    public SocioMysql update( @PathVariable String dni, @PathVariable String estado) {
        return servicio.save(dni,estado);
    }
}
