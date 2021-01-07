package com.geolocalizacao.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.geolocalizacao.api.model.ProvinciaModel;
import com.geolocalizacao.domain.model.Provincia;
import com.geolocalizacao.domain.repository.ProvinciaRepository;
import com.geolocalizacao.domain.service.CadastroProvinciaService;

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
@RequestMapping("/provincias")
public class ProvinciaController{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private CadastroProvinciaService cadastroProvinciaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ProvinciaModel> listar() {
        return toCollectionModel(provinciaRepository.findAll());
    }


    // @GetMapping("/{ordemServicoId}")
    // public ResponseEntity<OrdemServicoModel> buscar(@PathVariable Long ordemServicoId){

    //     Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);

    //     if(ordemServico.isPresent()){
    //         OrdemServicoModel ordemServicoModel = toModel(ordemServico.get());
    //       return ResponseEntity.ok(ordemServicoModel);
    //     }

    //     return ResponseEntity.notFound().build();

    // }


    @GetMapping("/{provinciaId}")
    public ResponseEntity<ProvinciaModel> buscar(@PathVariable Long provinciaId){

        Optional<Provincia> provincia = provinciaRepository.findById(provinciaId);

         if(provincia.isPresent()){
            return  ResponseEntity.ok(toModel(provincia.get()));
         }

         return ResponseEntity.notFound().build();
    }


    // @GetMapping
    // public List<OrdemServicoModel> listar(){
    //     return toCollectionModel(ordemServicoRepository.findAll());
    // }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Provincia adicionar(@Valid @RequestBody Provincia provincia) {
        
        
        return cadastroProvinciaService.salvar(provincia);
    }




    private ProvinciaModel toModel(Provincia provincia){

        return modelMapper.map(provincia, ProvinciaModel.class);
     }
    
    private List<ProvinciaModel> toCollectionModel(List<Provincia> provincias){

        return provincias.stream()
        .map(provincia -> toModel(provincia))
        .collect(Collectors.toList());
        
    }


}

