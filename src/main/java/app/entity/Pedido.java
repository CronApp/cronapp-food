package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela pedido
* @generated
*/
@Entity
@Table(name = "\"pedido\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Pedido")
public class Pedido implements Serializable {

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
    @Column(name = "data_pedido", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String dataPedido;

    /**
    * @generated
    */
    @Column(name = "statusPedido", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String statusPedido;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private User user;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_restaurante", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private Restaurante restaurante;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_formaPagamento", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private FormaPagamento formaPagamento;

    /**
    * @generated
    */
    @Column(name = "cep", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String cep;

    /**
    * @generated
    */
    @Column(name = "rua", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String rua;

    /**
    * @generated
    */
    @Column(name = "numero", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String numero;

    /**
    * @generated
    */
    @Column(name = "bairro", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String bairro;

    /**
    * @generated
    */
    @Column(name = "cidade", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String cidade;

    /**
    * @generated
    */
    @Column(name = "estado", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String estado;

    /**
    * Construtor
    * @generated
    */
    public Pedido(){
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
    public Pedido setId(java.lang.String id){
        this.id = id;
        return this;
    }
    /**
    * Obtém dataPedido
    * return dataPedido
    * @generated
    */
    
    public java.lang.String getDataPedido(){
        return this.dataPedido;
    }

    /**
    * Define dataPedido
    * @param dataPedido dataPedido
    * @generated
    */
    public Pedido setDataPedido(java.lang.String dataPedido){
        this.dataPedido = dataPedido;
        return this;
    }
    /**
    * Obtém statusPedido
    * return statusPedido
    * @generated
    */
    
    public java.lang.String getStatusPedido(){
        return this.statusPedido;
    }

    /**
    * Define statusPedido
    * @param statusPedido statusPedido
    * @generated
    */
    public Pedido setStatusPedido(java.lang.String statusPedido){
        this.statusPedido = statusPedido;
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
    public Pedido setUser(User user){
        this.user = user;
        return this;
    }
    /**
    * Obtém restaurante
    * return restaurante
    * @generated
    */
    
    public Restaurante getRestaurante(){
        return this.restaurante;
    }

    /**
    * Define restaurante
    * @param restaurante restaurante
    * @generated
    */
    public Pedido setRestaurante(Restaurante restaurante){
        this.restaurante = restaurante;
        return this;
    }
    /**
    * Obtém formaPagamento
    * return formaPagamento
    * @generated
    */
    
    public FormaPagamento getFormaPagamento(){
        return this.formaPagamento;
    }

    /**
    * Define formaPagamento
    * @param formaPagamento formaPagamento
    * @generated
    */
    public Pedido setFormaPagamento(FormaPagamento formaPagamento){
        this.formaPagamento = formaPagamento;
        return this;
    }
    /**
    * Obtém cep
    * return cep
    * @generated
    */
    
    public java.lang.String getCep(){
        return this.cep;
    }

    /**
    * Define cep
    * @param cep cep
    * @generated
    */
    public Pedido setCep(java.lang.String cep){
        this.cep = cep;
        return this;
    }
    /**
    * Obtém rua
    * return rua
    * @generated
    */
    
    public java.lang.String getRua(){
        return this.rua;
    }

    /**
    * Define rua
    * @param rua rua
    * @generated
    */
    public Pedido setRua(java.lang.String rua){
        this.rua = rua;
        return this;
    }
    /**
    * Obtém numero
    * return numero
    * @generated
    */
    
    public java.lang.String getNumero(){
        return this.numero;
    }

    /**
    * Define numero
    * @param numero numero
    * @generated
    */
    public Pedido setNumero(java.lang.String numero){
        this.numero = numero;
        return this;
    }
    /**
    * Obtém bairro
    * return bairro
    * @generated
    */
    
    public java.lang.String getBairro(){
        return this.bairro;
    }

    /**
    * Define bairro
    * @param bairro bairro
    * @generated
    */
    public Pedido setBairro(java.lang.String bairro){
        this.bairro = bairro;
        return this;
    }
    /**
    * Obtém cidade
    * return cidade
    * @generated
    */
    
    public java.lang.String getCidade(){
        return this.cidade;
    }

    /**
    * Define cidade
    * @param cidade cidade
    * @generated
    */
    public Pedido setCidade(java.lang.String cidade){
        this.cidade = cidade;
        return this;
    }
    /**
    * Obtém estado
    * return estado
    * @generated
    */
    
    public java.lang.String getEstado(){
        return this.estado;
    }

    /**
    * Define estado
    * @param estado estado
    * @generated
    */
    public Pedido setEstado(java.lang.String estado){
        this.estado = estado;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Pedido object = (Pedido)obj;
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