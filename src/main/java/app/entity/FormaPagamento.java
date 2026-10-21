
package app.entity;

import java.io.*;
import jakarta.persistence.*;
import java.util.*;
import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;



import cronapp.framework.core.persistence.*;

/**
* Classe que representa a tabela forma_pagamento
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"forma_pagamento\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.FormaPagamento")
@CronappTable(role=CronappTableRole.AUTO)
public class FormaPagamento implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @CronappColumn(attributeType="STRING", label="Id", defaultValue = "UUID.randomUUID().toString().toUpperCase()")
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="{{'Descricao' | translate}}")
    @Column(name = "descricao", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String descricao;


    /**
    * @generated
    */
    @CronappColumn(attributeType="IMAGE_DATABASE", label="Icone")
    @Column(name = "icone", nullable = false, unique = false, insertable=true, updatable=true)
        
        private byte[] icone;


    /**
    * Construtor
    * @generated
    */
    public FormaPagamento(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public FormaPagamento setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém descricao
    * return descricao
    * @generated
    */
    public java.lang.String getDescricao() {
        return this.descricao;
    }

    /**
    * Define descricao
    * @param descricao descricao
    * @generated
    */
    public FormaPagamento setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
        return this;
    }
    /**
    * Obtém icone
    * return icone
    * @generated
    */
    public byte[] getIcone() {
        return this.icone;
    }

    /**
    * Define icone
    * @param icone icone
    * @generated
    */
    public FormaPagamento setIcone(byte[] icone) {
        this.icone = icone;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
FormaPagamento object = (FormaPagamento)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
