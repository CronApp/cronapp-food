package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela item_cardapio
* @generated
*/
@Entity
@Table(name = "\"item_cardapio\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.ItemCardapio")
public class ItemCardapio implements Serializable {

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
    @Column(name = "titulo", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String titulo;

    /**
    * @generated
    */
    @Column(name = "descricao", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String descricao;

    /**
    * @generated
    */
    @Column(name = "foto", nullable = true, unique = false, insertable=true, updatable=true)
        
        private byte[] foto;

    /**
    * @generated
    */
    @Column(name = "preco", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Double preco;

    /**
    * @generated
    */
    @Column(name = "serve_pessoas", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer servePessoas;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_categoriaCardapio", nullable = false, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private CategoriaCardapio categoriaCardapio;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_restaurante", nullable = false, referencedColumnName = "id", insertable=true, updatable=true, foreignKey = @ForeignKey(name = ""))
        
        private Restaurante restaurante;

    /**
    * @generated
    */
    @Column(name = "promocao", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean promocao;

    /**
    * @generated
    */
    @Column(name = "precoPromocional", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Double precoPromocional;

    /**
    * Construtor
    * @generated
    */
    public ItemCardapio(){
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
    public ItemCardapio setId(java.lang.String id){
        this.id = id;
        return this;
    }
    /**
    * Obtém titulo
    * return titulo
    * @generated
    */
    
    public java.lang.String getTitulo(){
        return this.titulo;
    }

    /**
    * Define titulo
    * @param titulo titulo
    * @generated
    */
    public ItemCardapio setTitulo(java.lang.String titulo){
        this.titulo = titulo;
        return this;
    }
    /**
    * Obtém descricao
    * return descricao
    * @generated
    */
    
    public java.lang.String getDescricao(){
        return this.descricao;
    }

    /**
    * Define descricao
    * @param descricao descricao
    * @generated
    */
    public ItemCardapio setDescricao(java.lang.String descricao){
        this.descricao = descricao;
        return this;
    }
    /**
    * Obtém foto
    * return foto
    * @generated
    */
    
    public byte[] getFoto(){
        return this.foto;
    }

    /**
    * Define foto
    * @param foto foto
    * @generated
    */
    public ItemCardapio setFoto(byte[] foto){
        this.foto = foto;
        return this;
    }
    /**
    * Obtém preco
    * return preco
    * @generated
    */
    
    public java.lang.Double getPreco(){
        return this.preco;
    }

    /**
    * Define preco
    * @param preco preco
    * @generated
    */
    public ItemCardapio setPreco(java.lang.Double preco){
        this.preco = preco;
        return this;
    }
    /**
    * Obtém servePessoas
    * return servePessoas
    * @generated
    */
    
    public java.lang.Integer getServePessoas(){
        return this.servePessoas;
    }

    /**
    * Define servePessoas
    * @param servePessoas servePessoas
    * @generated
    */
    public ItemCardapio setServePessoas(java.lang.Integer servePessoas){
        this.servePessoas = servePessoas;
        return this;
    }
    /**
    * Obtém categoriaCardapio
    * return categoriaCardapio
    * @generated
    */
    
    public CategoriaCardapio getCategoriaCardapio(){
        return this.categoriaCardapio;
    }

    /**
    * Define categoriaCardapio
    * @param categoriaCardapio categoriaCardapio
    * @generated
    */
    public ItemCardapio setCategoriaCardapio(CategoriaCardapio categoriaCardapio){
        this.categoriaCardapio = categoriaCardapio;
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
    public ItemCardapio setRestaurante(Restaurante restaurante){
        this.restaurante = restaurante;
        return this;
    }
    /**
    * Obtém promocao
    * return promocao
    * @generated
    */
    
    public java.lang.Boolean getPromocao(){
        return this.promocao;
    }

    /**
    * Define promocao
    * @param promocao promocao
    * @generated
    */
    public ItemCardapio setPromocao(java.lang.Boolean promocao){
        this.promocao = promocao;
        return this;
    }
    /**
    * Obtém precoPromocional
    * return precoPromocional
    * @generated
    */
    
    public java.lang.Double getPrecoPromocional(){
        return this.precoPromocional;
    }

    /**
    * Define precoPromocional
    * @param precoPromocional precoPromocional
    * @generated
    */
    public ItemCardapio setPrecoPromocional(java.lang.Double precoPromocional){
        this.precoPromocional = precoPromocional;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
ItemCardapio object = (ItemCardapio)obj;
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