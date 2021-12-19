package com.ms.practica2.service;

import com.ms.practica2.model.SocioMysql;

public interface SocioService {

     SocioMysql save(String dni, String estado);

}
