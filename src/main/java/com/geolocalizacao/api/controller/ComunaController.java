package com.geolocalizacao.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.geolocalizacao.api.model.ComunaModel;
import com.geolocalizacao.domain.exception.EntidadeNaoEncontradaException;
import com.geolocalizacao.domain.model.Comuna;
import com.geolocalizacao.domain.model.Municipio;
import com.geolocalizacao.domain.repository.ComunaRepository;
import com.geolocalizacao.domain.repository.MunicipioRepository;
import com.geolocalizacao.domain.service.CadastroComunaService;

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
@RequestMapping("/comunas")
public class ComunaController{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ComunaRepository comunaRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private CadastroComunaService cadastroComunaService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/{municipioId}")
    public List<ComunaModel> listar(@PathVariable Long municipioId){
      Municipio municipio = municipioRepository.findById(municipioId)
      .orElseThrow(() -> new EntidadeNaoEncontradaException("Municipio Não Encontrada"));

      return toCollectionModel(municipio.getComunas());
    }


    @GetMapping("/{comunaId}/1")
    public ResponseEntity<ComunaModel> buscar(@PathVariable Long comunaId){

        Optional<Comuna> comuna = comunaRepository.findById(comunaId);

         if(comuna.isPresent()){
            return  ResponseEntity.ok(toModel(comuna.get()));
         }

         return ResponseEntity.notFound().build();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comuna adicionar(@Valid @RequestBody Comuna comuna) {
        
        
        return cadastroComunaService.salvar(comuna);
    }



    private ComunaModel toModel(Comuna comuna){

      return modelMapper.map(comuna, ComunaModel.class);
   }


   private List<ComunaModel> toCollectionModel(List<Comuna> comunas){

       return comunas.stream()
       .map(comuna -> toModel(comuna))
       .collect(Collectors.toList());
   }

}

