package com.geolocalizacao.domain.repository;

import java.util.List;

import com.geolocalizacao.domain.model.Municipio;
import com.geolocalizacao.domain.model.Provincia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio,Long> {
    
    List<Municipio> findByProvincia(Provincia provincia);
    
    Municipio findByCodigo(String codigo);
}
