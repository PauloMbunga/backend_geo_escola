package com.geolocalizacao.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class NumeroSequencial {

    @Id
    @GeneratedValue(generator = "increment")  
    @GenericGenerator(name="increment", strategy = "increment")
    private  Long id;
  
  @NotNull
  private Integer numero;

  public Long getId() {
      return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public Integer getNumero() {
      return numero;
  }

  public void setNumero(Integer numero) {
      this.numero = numero;
  }


  

  
    
}
