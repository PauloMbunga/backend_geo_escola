package com.geolocalizacao.domain.service;

import com.geolocalizacao.domain.exception.NegocioException;
import com.geolocalizacao.domain.model.Comuna;
import com.geolocalizacao.domain.repository.ComunaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroComunaService {


@Autowired
private ComunaRepository comunaRepository;

 public Comuna salvar (Comuna comuna){

    Comuna comunaExistente = comunaRepository.findByCodigo(comuna.getCodigo());
       if(comunaExistente != null && !comunaExistente.equals(comuna)){
         
         throw new NegocioException("Já existe um comuna cadastrado com este nome.");

       }

       return comunaRepository.save(comuna);

    }

    public void excluir(Long id){
        comunaRepository.deleteById(id);

    }
    
}

    

