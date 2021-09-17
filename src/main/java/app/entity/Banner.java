package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela banner
* @generated
*/
@Entity
@Table(name = "\"banner\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Banner")
public class Banner implements Serializable {

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
    @Column(name = "imagem", nullable = false, unique = false, insertable=true, updatable=true)
        
        private byte[] imagem;

    /**
    * @generated
    */
    @Column(name = "titulo", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String titulo;

    /**
    * @generated
    */
    @Column(name = "conteudo", nullable = false, unique = false, insertable=true, updatable=true, columnDefinition = "TEXT")
        
        private java.lang.String conteudo;

    /**
    * Construtor
    * @generated
    */
    public Banner(){
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
    public Banner setId(java.lang.String id){
        this.id = id;
        return this;
    }
    /**
    * Obtém imagem
    * return imagem
    * @generated
    */
    
    public byte[] getImagem(){
        return this.imagem;
    }

    /**
    * Define imagem
    * @param imagem imagem
    * @generated
    */
    public Banner setImagem(byte[] imagem){
        this.imagem = imagem;
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
    public Banner setTitulo(java.lang.String titulo){
        this.titulo = titulo;
        return this;
    }
    /**
    * Obtém conteudo
    * return conteudo
    * @generated
    */
    
    public java.lang.String getConteudo(){
        return this.conteudo;
    }

    /**
    * Define conteudo
    * @param conteudo conteudo
    * @generated
    */
    public Banner setConteudo(java.lang.String conteudo){
        this.conteudo = conteudo;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Banner object = (Banner)obj;
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