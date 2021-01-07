package com.geolocalizacao.api.model;

public class MunicipioModel {

        private Long id;
        private String descricao;
        private String codigo;
        private ProvinciaModel provincia;

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

        public ProvinciaModel getProvincia() {
            return provincia;
        }

        public void setProvincia(ProvinciaModel provincia) {
            this.provincia = provincia;
        }

       
        

        
}
