package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;


/**
* @generated
*
**/
public class ItemCardapioPK implements Serializable {

  /**
  * @generated
  */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
   * @generated
   */
  private java.lang.Integer servePessoas;

  /**
   * Construtor
   * @generated
   */
  public ItemCardapioPK(){
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
  public ItemCardapioPK setId(java.lang.String id){
    this.id = id;
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
  public ItemCardapioPK setServePessoas(java.lang.Integer servePessoas){
    this.servePessoas = servePessoas;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
ItemCardapioPK object = (ItemCardapioPK)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    if (servePessoas != null ? !servePessoas.equals(object.servePessoas) : object.servePessoas != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    result = 31 * result + ((servePessoas == null) ? 0 : servePessoas.hashCode());
    return result;
  }

}
