package com.geolocalizacao.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.geolocalizacao.domain.model.NumeroSequencial;
import com.geolocalizacao.domain.repository.NumeroSequencialRepository;
import com.geolocalizacao.domain.service.CadastroNumeroSequencialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/numeroSequencial")
public class NumeroSequencialController{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private NumeroSequencialRepository numeroSequencialRepository;

    @Autowired
    private CadastroNumeroSequencialService cadastroNumeroSequencialService;

    // @GetMapping
    // public List<NumeroSequencial> listar() {
    //     return numeroSequencialRepository.findAll();
    // }


    @GetMapping
    public ResponseEntity<NumeroSequencial> buscarNumeroSequencial(){

        Optional<NumeroSequencial> nivelEscola = numeroSequencialRepository.findById(1L);

         if(nivelEscola.isPresent()){
            return ResponseEntity.ok(nivelEscola.get());
         }

         return ResponseEntity.notFound().build();
    }


    

    @PutMapping("/{numeroSequencialId}") 
    public ResponseEntity<NumeroSequencial> actualizar(@Valid @PathVariable Long numeroSequencialId,@RequestBody NumeroSequencial numeroSequencial){

         if(!numeroSequencialRepository.existsById(numeroSequencialId)){
             return ResponseEntity.notFound().build();

         }
         numeroSequencial.setId(numeroSequencialId);
         numeroSequencial = cadastroNumeroSequencialService.salvar(numeroSequencial);
         return ResponseEntity.ok(numeroSequencial);
    }
    


}

