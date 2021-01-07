package com.geolocalizacao.domain.service;

import com.geolocalizacao.domain.exception.NegocioException;
import com.geolocalizacao.domain.model.Provincia;
import com.geolocalizacao.domain.repository.ProvinciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroProvinciaService {


@Autowired
private ProvinciaRepository provinciaRepository;

 public Provincia salvar (Provincia provincia){

    Provincia provinciaExistente = provinciaRepository.findByDescricao(provincia.getDescricao());
       if(provinciaExistente != null && !provinciaExistente.equals(provincia)){
         
         throw new NegocioException("Já existe um provincia cadastrado com este nome.");

       }

       return provinciaRepository.save(provincia);

    }

    public void excluir(Long id){
        provinciaRepository.deleteById(id);

    }
    
}

    

