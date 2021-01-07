package com.geolocalizacao.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.geolocalizacao.api.model.MunicipioModel;
import com.geolocalizacao.domain.exception.EntidadeNaoEncontradaException;
import com.geolocalizacao.domain.model.Municipio;
import com.geolocalizacao.domain.model.Provincia;
import com.geolocalizacao.domain.repository.MunicipioRepository;
import com.geolocalizacao.domain.repository.ProvinciaRepository;
import com.geolocalizacao.domain.service.CadastroMunicipioService;

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
@RequestMapping("/municipios")
public class MunicipioController{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private CadastroMunicipioService cadastroMunicipioService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/{provinciaId}")
    public List<MunicipioModel> listar(@PathVariable Long provinciaId){
      Provincia provincia = provinciaRepository.findById(provinciaId)
      .orElseThrow(() -> new EntidadeNaoEncontradaException("Provincia Não Encontrada"));

      return toCollectionModel(provincia.getMunicipios());
    }


    @GetMapping("/{municipioId}/1")
    public ResponseEntity<MunicipioModel> buscar(@PathVariable Long municipioId){

        Optional<Municipio> municipio = municipioRepository.findById(municipioId);

         if(municipio.isPresent()){
            return  ResponseEntity.ok(toModel(municipio.get()));
         }

         return ResponseEntity.notFound().build();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Municipio adicionar(@Valid @RequestBody Municipio municipio) {
        
        
        return cadastroMunicipioService.salvar(municipio);
    }






    private MunicipioModel toModel(Municipio municipio){

      return modelMapper.map(municipio, MunicipioModel.class);
   }


   private List<MunicipioModel> toCollectionModel(List<Municipio> municipios){

       return municipios.stream()
       .map(municipio -> toModel(municipio))
       .collect(Collectors.toList());
   }

}

