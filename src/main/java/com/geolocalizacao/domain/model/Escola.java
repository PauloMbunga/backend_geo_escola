package com.geolocalizacao.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

//import com.pmbunga.api.domain.ValidationGroups;

@Entity
public class Escola {

    @Id
    @GeneratedValue(generator = "increment")  
    @GenericGenerator(name="increment", strategy = "increment")
    private  Long id;
  
  @NotBlank
  @Size(max = 1000) 
  private  String nome;

  @NotBlank
  @Size(max = 11)
  private  String codigoEscola;

  @NotNull
  private BigDecimal latitude;

  @NotNull
  private BigDecimal longitude;


  @ManyToOne
  private Comuna comuna;


  @ManyToOne
  private NivelEscola nivelEscola;
  
 

  public Long getId() {
      return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  

  

  public String getNome() {
      return nome;
  }

  public void setNome(String nome) {
      this.nome = nome;
  }

  

  public BigDecimal getLatitude() {
      return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
      this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
      return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
      this.longitude = longitude;
  }

  public Comuna getComuna() {
      return comuna;
  }

  public void setComuna(Comuna comuna) {
      this.comuna = comuna;
  }

  

  @Override
  public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
  }

  @Override
  public boolean equals(Object obj) {
      if (this == obj)
          return true;
      if (obj == null)
          return false;
      if (getClass() != obj.getClass())
          return false;
      Escola other = (Escola) obj;
      if (id == null) {
          if (other.id != null)
              return false;
      } else if (!id.equals(other.id))
          return false;
      return true;
  }

  public String getCodigoEscola() {
      return codigoEscola;
  }

  public void setCodigoEscola(String codigoEscola) {
      this.codigoEscola = codigoEscola;
  }

  public NivelEscola getNivelEscola() {
      return nivelEscola;
  }

  public void setNivelEscola(NivelEscola nivelEscola) {
      this.nivelEscola = nivelEscola;
  }

  
    
  
}
