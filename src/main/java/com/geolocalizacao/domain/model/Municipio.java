package com.geolocalizacao.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

//import com.pmbunga.api.domain.ValidationGroups;

@Entity
public class Municipio {

    @Id
    @GeneratedValue(generator = "increment")  
    @GenericGenerator(name="increment", strategy = "increment")
    private  Long id;
  
  @NotBlank
  @Size(max = 800) 
  private  String descricao;

  @NotBlank
  @Size(max = 2)
  private  String codigo;

  @ManyToOne
  private Provincia provincia;


  @OneToMany(mappedBy = "municipio")
  private List<Comuna> comunas = new ArrayList<>();
  
 

  public Long getId() {
      return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public String getDescricao() {
      return descricao;
  }

  public void setDescricao(String descricao) {
      this.descricao = descricao;
  }

  public String getCodigo() {
      return codigo;
  }

  public void setCodigo(String codigo) {
      this.codigo = codigo;
  }


  public Provincia getProvincia() {
    return provincia;
}

public void setProvincia(Provincia provincia) {
    this.provincia = provincia;
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
      Municipio other = (Municipio) obj;
      if (id == null) {
          if (other.id != null)
              return false;
      } else if (!id.equals(other.id))
          return false;
      return true;
  }

  public List<Comuna> getComunas() {
      return comunas;
  }

  public void setComunas(List<Comuna> comunas) {
      this.comunas = comunas;
  }

  

  
    
  
}
