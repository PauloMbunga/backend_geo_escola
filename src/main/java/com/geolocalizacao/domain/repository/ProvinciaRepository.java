package com.geolocalizacao.domain.repository;

import java.util.List;
import java.util.Optional;

import com.geolocalizacao.api.model.ProvinciaModel;
import com.geolocalizacao.domain.model.Provincia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    Provincia findByDescricao(String descricao);
    
   

}
