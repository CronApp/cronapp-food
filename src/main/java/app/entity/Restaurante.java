
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
* Classe que representa a tabela restaurante
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"restaurante\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Restaurante")
@CronappTable(role=CronappTableRole.AUTO)
public class Restaurante implements Serializable {
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
    @CronappColumn(attributeType="STRING", label="{{'Nome' | translate}}")
    @Column(name = "nome", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String nome;


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="{{'Descricao' | translate}}")
    @Column(name = "descricao", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String descricao;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="{{'PermiteRetirada' | translate}}")
    @Column(name = "permite_retirada", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean permiteRetirada;


    /**
    * @generated
    */
    @CronappColumn(attributeType="BOOLEAN", label="{{'RealizaEntrega' | translate}}")
    @Column(name = "realiza_entrega", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean realizaEntrega;


    /**
    * @generated
    */
    @Temporal(TemporalType.TIME)
    @CronappColumn(attributeType="TIME", label="{{'TempoEntrega' | translate}}")
    @Column(name = "tempo_entrega", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date tempoEntrega;


    /**
    * @generated
    */
    @CronappColumn(attributeType="DOUBLE", label="{{'TaxaEntrega' | translate}}")
    @Column(name = "taxa_entrega", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Double taxaEntrega;


    /**
    * @generated
    */
    @CronappColumn(attributeType="IMAGE_DATABASE", label="{{'Logotipo' | translate}}")
    @Column(name = "logotipo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private byte[] logotipo;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_categoriaRestaurante", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private CategoriaRestaurante categoriaRestaurante;


    /**
    * Construtor
    * @generated
    */
    public Restaurante(){
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
    public Restaurante setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém nome
    * return nome
    * @generated
    */
    public java.lang.String getNome() {
        return this.nome;
    }

    /**
    * Define nome
    * @param nome nome
    * @generated
    */
    public Restaurante setNome(java.lang.String nome) {
        this.nome = nome;
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
    public Restaurante setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
        return this;
    }
    /**
    * Obtém permiteRetirada
    * return permiteRetirada
    * @generated
    */
    public java.lang.Boolean getPermiteRetirada() {
        return this.permiteRetirada;
    }

    /**
    * Define permiteRetirada
    * @param permiteRetirada permiteRetirada
    * @generated
    */
    public Restaurante setPermiteRetirada(java.lang.Boolean permiteRetirada) {
        this.permiteRetirada = permiteRetirada;
        return this;
    }
    /**
    * Obtém realizaEntrega
    * return realizaEntrega
    * @generated
    */
    public java.lang.Boolean getRealizaEntrega() {
        return this.realizaEntrega;
    }

    /**
    * Define realizaEntrega
    * @param realizaEntrega realizaEntrega
    * @generated
    */
    public Restaurante setRealizaEntrega(java.lang.Boolean realizaEntrega) {
        this.realizaEntrega = realizaEntrega;
        return this;
    }
    /**
    * Obtém tempoEntrega
    * return tempoEntrega
    * @generated
    */
    public java.util.Date getTempoEntrega() {
        return this.tempoEntrega;
    }

    /**
    * Define tempoEntrega
    * @param tempoEntrega tempoEntrega
    * @generated
    */
    public Restaurante setTempoEntrega(java.util.Date tempoEntrega) {
        this.tempoEntrega = tempoEntrega;
        return this;
    }
    /**
    * Obtém taxaEntrega
    * return taxaEntrega
    * @generated
    */
    public java.lang.Double getTaxaEntrega() {
        return this.taxaEntrega;
    }

    /**
    * Define taxaEntrega
    * @param taxaEntrega taxaEntrega
    * @generated
    */
    public Restaurante setTaxaEntrega(java.lang.Double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
        return this;
    }
    /**
    * Obtém logotipo
    * return logotipo
    * @generated
    */
    public byte[] getLogotipo() {
        return this.logotipo;
    }

    /**
    * Define logotipo
    * @param logotipo logotipo
    * @generated
    */
    public Restaurante setLogotipo(byte[] logotipo) {
        this.logotipo = logotipo;
        return this;
    }
    /**
    * Obtém categoriaRestaurante
    * return categoriaRestaurante
    * @generated
    */
    public CategoriaRestaurante getCategoriaRestaurante() {
        return this.categoriaRestaurante;
    }

    /**
    * Define categoriaRestaurante
    * @param categoriaRestaurante categoriaRestaurante
    * @generated
    */
    public Restaurante setCategoriaRestaurante(CategoriaRestaurante categoriaRestaurante) {
        this.categoriaRestaurante = categoriaRestaurante;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Restaurante object = (Restaurante)obj;
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
