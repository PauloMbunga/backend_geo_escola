package com.geolocalizacao.domain.repository;

import java.util.Optional;

import com.geolocalizacao.domain.model.NumeroSequencial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumeroSequencialRepository extends JpaRepository<NumeroSequencial, Long> {

    Optional<NumeroSequencial> findById(Long id);

}
