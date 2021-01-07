package com.geolocalizacao.domain.service;

import com.geolocalizacao.domain.exception.NegocioException;
import com.geolocalizacao.domain.model.Municipio;
import com.geolocalizacao.domain.repository.MunicipioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroMunicipioService {


@Autowired
private MunicipioRepository municipioRepository;

 public Municipio salvar (Municipio municipio){

    // Municipio municipioExistente = municipioRepository.findByCodigo(municipio.getCodigo());
    //    if(municipioExistente != null && !municipioExistente.equals(municipio)){
         
    //      throw new NegocioException("Já existe um municipio cadastrado com este nome.");

    //    }

       return municipioRepository.save(municipio);

    }

    public void excluir(Long id){
        municipioRepository.deleteById(id);

    }
    
}

    

