package com.geolocalizacao.api.model;

import java.math.BigDecimal;

import com.geolocalizacao.domain.model.NivelEscola;

public class EscolaModel {

    
  private  Long id;
  private  String nome;
  private  String codigoEscola;
  private BigDecimal latitude;
  private BigDecimal longitude;
  private ComunaModel comuna;
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

  public String getCodigoEscola() {
      return codigoEscola;
  }

  public void setCodigoEscola(String codigoEscola) {
      this.codigoEscola = codigoEscola;
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

  public ComunaModel getComuna() {
      return comuna;
  }

  public void setComuna(ComunaModel comuna) {
      this.comuna = comuna;
  }

  public NivelEscola getNivelEscola() {
      return nivelEscola;
  }

  public void setNivelEscola(NivelEscola nivelEscola) {
      this.nivelEscola = nivelEscola;
  }


  
    
}
