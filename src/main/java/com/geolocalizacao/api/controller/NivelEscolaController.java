package com.geolocalizacao.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.geolocalizacao.domain.model.NivelEscola;
import com.geolocalizacao.domain.repository.NivelEscolaRepository;
import com.geolocalizacao.domain.service.CadastroNivelEscolaService;

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
@RequestMapping("/nivelEscolas")
public class NivelEscolaController{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private NivelEscolaRepository nivelEscolaRepository;

    @Autowired
    private CadastroNivelEscolaService cadastroNivelEscolaService;

    @GetMapping
    public List<NivelEscola> listar() {
        return nivelEscolaRepository.findAll();
    }


    @GetMapping("/{nivelEscolaId}")
    public ResponseEntity<NivelEscola> buscar(@PathVariable Long nivelEscolaId){

        Optional<NivelEscola> nivelEscola = nivelEscolaRepository.findById(nivelEscolaId);

         if(nivelEscola.isPresent()){
            return ResponseEntity.ok(nivelEscola.get());
         }

         return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NivelEscola adicionar(@Valid @RequestBody NivelEscola nivelEscola) {
        
        
        return cadastroNivelEscolaService.salvar(nivelEscola);
    }

    @PutMapping("/{nivelEscolaId}") 
    public ResponseEntity<NivelEscola> actualizar(@Valid @PathVariable Long nivelEscolaId,@RequestBody NivelEscola nivelEscola){

         if(!nivelEscolaRepository.existsById(nivelEscolaId)){
             return ResponseEntity.notFound().build();

         }
         nivelEscola.setId(nivelEscolaId);
         nivelEscola = cadastroNivelEscolaService.salvar(nivelEscola);
         return ResponseEntity.ok(nivelEscola);
    }
    
    @DeleteMapping("/{nivelEscolaId}")
   public ResponseEntity<Void> remover(@PathVariable Long nivelEscolaId){

      if(!nivelEscolaRepository.existsById(nivelEscolaId)){

        return ResponseEntity.notFound().build();
      }

      cadastroNivelEscolaService.excluir(nivelEscolaId);

      return ResponseEntity.noContent().build();
   }


}

