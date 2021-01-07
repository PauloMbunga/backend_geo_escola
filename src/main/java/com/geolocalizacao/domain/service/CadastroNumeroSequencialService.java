package com.geolocalizacao.domain.service;

import com.geolocalizacao.domain.exception.NegocioException;
import com.geolocalizacao.domain.model.NivelEscola;
import com.geolocalizacao.domain.model.NumeroSequencial;
import com.geolocalizacao.domain.repository.NivelEscolaRepository;
import com.geolocalizacao.domain.repository.NumeroSequencialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroNumeroSequencialService {


@Autowired
private NumeroSequencialRepository numeroSequencialRepository;

 public NumeroSequencial salvar (NumeroSequencial numeroSequencial){

       return numeroSequencialRepository.save(numeroSequencial);

    }

    public void excluir(Long id){
        numeroSequencialRepository.deleteById(id);

    }
    
}

    

