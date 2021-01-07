package com.geolocalizacao.domain.repository;

import java.util.List;

import com.geolocalizacao.domain.model.Comuna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna,Long> {
    
    Comuna findByCodigo(String codigo);

}
