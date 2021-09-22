package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Restaurante {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Restaurante
public static Var getRestaurantePorUsuario() throws Exception {
 return new Callable<Var>() {

   private Var listRestaurantes = Var.VAR_NULL;
   private Var restauranteLogado = Var.VAR_NULL;

   public Var call() throws Exception {

    listRestaurantes =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u.restaurante from User u where u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.text.Operations.normalize(
    cronapi.util.Operations.getCurrentUserName())));

    restauranteLogado =
    cronapi.list.Operations.getFirst(listRestaurantes);
    return restauranteLogado;
   }
 }.call();
}

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var getLogoRestaurante(@ParamMetaData(description = "idProduto") Var idProduto) throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {

    lista =
    cronapi.database.Operations.query(Var.valueOf("app.entity.ItemCardapio"),Var.valueOf("select i.restaurante from ItemCardapio i where i.id = :id"),Var.valueOf("id",idProduto));

    item =
    cronapi.list.Operations.getFirst(lista);
    return
cronapi.object.Operations.getObjectField(item, Var.valueOf("logotipo"));
   }
 }.call();
}

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var getRestaurantePorIdProduto(@ParamMetaData(description = "id2") Var id2) throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;
   private Var retorno = Var.VAR_NULL;

   public Var call() throws Exception {

    retorno =
    cronapi.database.Operations.query(Var.valueOf("app.entity.ItemCardapio"),Var.valueOf("select i.restaurante from ItemCardapio i where i.id = :id"),Var.valueOf("id",id2));

    item =
    cronapi.json.Operations.createObjectJson();

    cronapi.json.Operations.setJsonOrMapField(item,
    Var.valueOf("nome"),
    cronapi.object.Operations.getObjectField(retorno, Var.valueOf("nome")));

    cronapi.json.Operations.setJsonOrMapField(item,
    Var.valueOf("logotipoRestaurante"),
    cronapi.object.Operations.getObjectField(retorno, Var.valueOf("logotipo")));

    cronapi.json.Operations.setJsonOrMapField(item,
    Var.valueOf("id"),
    cronapi.object.Operations.getObjectField(retorno, Var.valueOf("id")));

    cronapi.json.Operations.setJsonOrMapField(item,
    Var.valueOf("taxaEntrega"),
    cronapi.object.Operations.getObjectField(retorno, Var.valueOf("taxaEntrega")));

    cronapi.json.Operations.setJsonOrMapField(item,
    Var.valueOf("tempoEntrega"),
    cronapi.object.Operations.getObjectField(retorno, Var.valueOf("tempoEntrega")));
    return item;
   }
 }.call();
}

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var getRestaurentePorId(@ParamMetaData(description = "id2") Var id2) throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;
   private Var idProduto = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var listRestaurantes = Var.VAR_NULL;
   private Var restauranteLogado = Var.VAR_NULL;

   public Var call() throws Exception {
    return
cronapi.database.Operations.query(Var.valueOf("app.entity.Restaurante"),Var.valueOf("select r from Restaurante r where r.id = :id"),Var.valueOf("id",id2));
   }
 }.call();
}

}

