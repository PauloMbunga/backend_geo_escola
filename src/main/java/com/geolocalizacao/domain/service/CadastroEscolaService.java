package com.geolocalizacao.domain.service;

import com.geolocalizacao.domain.exception.NegocioException;
import com.geolocalizacao.domain.model.Escola;
import com.geolocalizacao.domain.repository.EscolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroEscolaService {


@Autowired
private EscolaRepository escolaRepository;

 public Escola salvar (Escola escola){

    Escola escolaExistente = escolaRepository.findByCodigoEscola(escola.getCodigoEscola());
       if(escolaExistente != null && !escolaExistente.equals(escola)){
         
         throw new NegocioException("Já existe um nivel de Escola cadastrado com este código.");

       }

       return escolaRepository.save(escola);

    }

    public void excluir(Long id){
      escolaRepository.deleteById(id);

    }
    
}

    

