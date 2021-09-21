package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela CARRINHO
* @generated
*/
@Entity
@Table(name = "\"CARRINHO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Carrinho")
public class Carrinho implements Serializable {

    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_itemCardapio", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private ItemCardapio itemCardapio;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private User user;

    /**
    * @generated
    */
    @Column(name = "quantidade", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer quantidade;

    /**
    * @generated
    */
    @Column(name = "valorUnitario", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Double valorUnitario;

    /**
    * Construtor
    * @generated
    */
    public Carrinho(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    
    public java.lang.String getId(){
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public Carrinho setId(java.lang.String id){
        this.id = id;
        return this;
    }
    /**
    * Obtém itemCardapio
    * return itemCardapio
    * @generated
    */
    
    public ItemCardapio getItemCardapio(){
        return this.itemCardapio;
    }

    /**
    * Define itemCardapio
    * @param itemCardapio itemCardapio
    * @generated
    */
    public Carrinho setItemCardapio(ItemCardapio itemCardapio){
        this.itemCardapio = itemCardapio;
        return this;
    }
    /**
    * Obtém user
    * return user
    * @generated
    */
    
    public User getUser(){
        return this.user;
    }

    /**
    * Define user
    * @param user user
    * @generated
    */
    public Carrinho setUser(User user){
        this.user = user;
        return this;
    }
    /**
    * Obtém quantidade
    * return quantidade
    * @generated
    */
    
    public java.lang.Integer getQuantidade(){
        return this.quantidade;
    }

    /**
    * Define quantidade
    * @param quantidade quantidade
    * @generated
    */
    public Carrinho setQuantidade(java.lang.Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }
    /**
    * Obtém valorUnitario
    * return valorUnitario
    * @generated
    */
    
    public java.lang.Double getValorUnitario(){
        return this.valorUnitario;
    }

    /**
    * Define valorUnitario
    * @param valorUnitario valorUnitario
    * @generated
    */
    public Carrinho setValorUnitario(java.lang.Double valorUnitario){
        this.valorUnitario = valorUnitario;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Carrinho object = (Carrinho)obj;
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