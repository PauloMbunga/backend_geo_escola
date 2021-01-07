package com.geolocalizacao.domain.repository;

import java.util.List;

import com.geolocalizacao.domain.model.NivelEscola;
import com.geolocalizacao.domain.model.Provincia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelEscolaRepository extends JpaRepository<NivelEscola,Long> {
     
    NivelEscola findByDescricao(String descricao);
}
