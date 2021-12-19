package com.ms.practica2.repository;

import com.ms.practica2.model.SocioMysql;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepository extends CrudRepository<SocioMysql, String> {
}
