package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela pedido_item
* @generated
*/
@Entity
@Table(name = "\"pedido_item\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.PedidoItem")
public class PedidoItem implements Serializable {

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
    @Column(name = "quantidade", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer quantidade;

    /**
    * @generated
    */
    @Column(name = "valor_unitario", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Double valorUnitario;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_pedido", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private Pedido pedido;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_itemCardapio", nullable = true, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private ItemCardapio itemCardapio;

    /**
    * Construtor
    * @generated
    */
    public PedidoItem(){
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
    public PedidoItem setId(java.lang.String id){
        this.id = id;
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
    public PedidoItem setQuantidade(java.lang.Integer quantidade){
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
    public PedidoItem setValorUnitario(java.lang.Double valorUnitario){
        this.valorUnitario = valorUnitario;
        return this;
    }
    /**
    * Obtém pedido
    * return pedido
    * @generated
    */
    
    public Pedido getPedido(){
        return this.pedido;
    }

    /**
    * Define pedido
    * @param pedido pedido
    * @generated
    */
    public PedidoItem setPedido(Pedido pedido){
        this.pedido = pedido;
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
    public PedidoItem setItemCardapio(ItemCardapio itemCardapio){
        this.itemCardapio = itemCardapio;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
PedidoItem object = (PedidoItem)obj;
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