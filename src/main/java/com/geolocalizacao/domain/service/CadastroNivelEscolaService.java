package com.geolocalizacao.domain.service;

import com.geolocalizacao.domain.exception.NegocioException;
import com.geolocalizacao.domain.model.NivelEscola;
import com.geolocalizacao.domain.repository.NivelEscolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroNivelEscolaService {


@Autowired
private NivelEscolaRepository nivelEscolaRepository;

 public NivelEscola salvar (NivelEscola nivelEscola){

    NivelEscola nivelEscolaExistente = nivelEscolaRepository.findByDescricao(nivelEscola.getDescricao());
       if(nivelEscolaExistente != null && !nivelEscolaExistente.equals(nivelEscola)){
         
         throw new NegocioException("Já existe um nivel de Escola cadastrado com este nome.");

       }

       return nivelEscolaRepository.save(nivelEscola);

    }

    public void excluir(Long id){
        nivelEscolaRepository.deleteById(id);

    }
    
}

    

