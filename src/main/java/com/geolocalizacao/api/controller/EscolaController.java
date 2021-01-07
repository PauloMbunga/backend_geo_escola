package com.geolocalizacao.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.geolocalizacao.api.model.EscolaModel;
import com.geolocalizacao.domain.model.Escola;
import com.geolocalizacao.domain.repository.EscolaRepository;
import com.geolocalizacao.domain.service.CadastroEscolaService;

import org.modelmapper.ModelMapper;
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
@RequestMapping("/escolas")
public class EscolaController{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private EscolaRepository escolaRepository;

    @Autowired
    private CadastroEscolaService cadastroEscolaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<EscolaModel> listar(){
        return toCollectionModel(escolaRepository.findAll());
    }


    @GetMapping("/{escolaId}")
    public ResponseEntity<Escola> buscar(@PathVariable Long escolaId){

        Optional<Escola> escola = escolaRepository.findById(escolaId);

         if(escola.isPresent()){
            return ResponseEntity.ok(escola.get());
         }

         return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Escola adicionar(@Valid @RequestBody Escola escola) {
        
        
        return cadastroEscolaService.salvar(escola);
    }

    @PutMapping("/{escolaId}") 
    public ResponseEntity<Escola> actualizar(@Valid @PathVariable Long escolaId,@RequestBody Escola escola){

         if(!escolaRepository.existsById(escolaId)){
             return ResponseEntity.notFound().build();

         }
         escola.setId(escolaId);
         escola = cadastroEscolaService.salvar(escola);
         return ResponseEntity.ok(escola);
    }
    
    @DeleteMapping("/{escolaId}")
   public ResponseEntity<Void> remover(@PathVariable Long escolaId){

      if(!escolaRepository.existsById(escolaId)){

        return ResponseEntity.notFound().build();
      }

      cadastroEscolaService.excluir(escolaId);

      return ResponseEntity.noContent().build();
   }


   private EscolaModel toModel(Escola escola){

    return modelMapper.map(escola, EscolaModel.class);
 }


 private List<EscolaModel> toCollectionModel(List<Escola> escolas){

     return escolas.stream()
     .map(comuna -> toModel(comuna))
     .collect(Collectors.toList());
 }



}

