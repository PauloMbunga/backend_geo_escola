package com.geolocalizacao.domain.repository;

import java.util.List;

import com.geolocalizacao.domain.model.Comuna;
import com.geolocalizacao.domain.model.Escola;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaRepository extends JpaRepository<Escola,Long> {
    
    Escola findByCodigoEscola(String codigoEscola);
}
