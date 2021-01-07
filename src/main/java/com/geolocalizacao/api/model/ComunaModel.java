package com.geolocalizacao.api.model;

public class ComunaModel {

        private Long id;
        private String descricao;
        private String codigo;

        private MunicipioModel municipio;

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

        public MunicipioModel getMunicipio() {
            return municipio;
        }

        public void setMunicipio(MunicipioModel municipio) {
            this.municipio = municipio;
        }

        
        
}
