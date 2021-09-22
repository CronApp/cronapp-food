package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Carrinho {

public static final int TIMEOUT = 300;

/**
 */
// Descreva esta função...
public static void esvaziarCarrinho() throws Exception {
  new Callable<Var>() {

   private Var lista = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;

   public Var call() throws Exception {

    lista =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Carrinho"),Var.valueOf("select c from Carrinho c where c.user = :user"),Var.valueOf("user",
    Var.valueOf(obterUsuarioLogado())));

    for (Iterator it_i = lista.iterator(); it_i.hasNext();) {
        i = Var.valueOf(it_i.next());

        cronapi.database.Operations.remove(Var.valueOf("app.entity.Carrinho"),i);
    } // end for
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var fecharPedido(@ParamMetaData(description = "formaPagamento") Var formaPagamento, @ParamMetaData(description = "cep") Var cep, @ParamMetaData(description = "logradouro") Var logradouro, @ParamMetaData(description = "numero") Var numero, @ParamMetaData(description = "bairro") Var bairro, @ParamMetaData(description = "cidade") Var cidade, @ParamMetaData(description = "uf") Var uf) throws Exception {
 return new Callable<Var>() {

   private Var retorno = Var.VAR_NULL;
   private Var restaurantes = Var.VAR_NULL;
   private Var restaurante = Var.VAR_NULL;
   private Var pedidoRestaurante = Var.VAR_NULL;
   private Var itensRestaurante = Var.VAR_NULL;
   private Var itemCarrinho = Var.VAR_NULL;
   private Var itemCardapio = Var.VAR_NULL;
   private Var itemPedido = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {

    retorno =
    Var.VAR_TRUE;

    try {

        restaurantes =
        cronapi.database.Operations.query(Var.valueOf("app.entity.Carrinho"),Var.valueOf("select c.itemCardapio.restaurante from Carrinho c"));

        for (Iterator it_restaurante = restaurantes.iterator(); it_restaurante.hasNext();) {
            restaurante = Var.valueOf(it_restaurante.next());

            pedidoRestaurante =
            cronapi.database.Operations.newEntity(Var.valueOf("app.entity.Pedido"),Var.valueOf("dataPedido",
            cronapi.dateTime.Operations.getNow()),Var.valueOf("statusPedido",
            Var.valueOf("Novo")),Var.valueOf("user",
            Var.valueOf(obterUsuarioLogado())),Var.valueOf("restaurante",restaurante),Var.valueOf("formaPagamento",formaPagamento),Var.valueOf("cep",cep),Var.valueOf("rua",logradouro),Var.valueOf("numero",numero),Var.valueOf("bairro",bairro),Var.valueOf("cidade",cidade),Var.valueOf("estado",uf));

            cronapi.database.Operations.insert(Var.valueOf("app.entity.Pedido"),pedidoRestaurante);

            itensRestaurante =
            cronapi.database.Operations.query(Var.valueOf("app.entity.Carrinho"),Var.valueOf("select c from Carrinho c where c.itemCardapio.restaurante = :itemCardapioRestaurante"),Var.valueOf("itemCardapioRestaurante",restaurante));

            for (Iterator it_itemCarrinho = itensRestaurante.iterator(); it_itemCarrinho.hasNext();) {
                itemCarrinho = Var.valueOf(it_itemCarrinho.next());

                itemCardapio =
                cronapi.object.Operations.getObjectField(itemCarrinho, Var.valueOf("itemCardapio"));

                itemPedido =
                cronapi.database.Operations.newEntity(Var.valueOf("app.entity.PedidoItem"),Var.valueOf("quantidade",
                Var.valueOf(1)),Var.valueOf("valorUnitario",
                cronapi.object.Operations.getObjectField(itemCardapio, Var.valueOf("preco"))),Var.valueOf("pedido",pedidoRestaurante),Var.valueOf("itemCardapio",itemCardapio));

                cronapi.database.Operations.insert(Var.valueOf("app.entity.PedidoItem"),itemPedido);
            } // end for
        } // end for

        esvaziarCarrinho();
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);

        retorno =
        Var.VAR_FALSE;
     }
    return retorno;
   }
 }.call();
}

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var getItemCarrinhoPorId(@ParamMetaData(description = "idItem") Var idItem) throws Exception {
 return new Callable<Var>() {

   private Var i = Var.VAR_NULL;
   private Var listaItens = Var.VAR_NULL;

   public Var call() throws Exception {

    listaItens =
    cronapi.database.Operations.query(Var.valueOf("app.entity.ItemCardapio"),Var.valueOf("select i from ItemCardapio i where i.id = :id"),Var.valueOf("id",idItem));
    return
cronapi.list.Operations.getFirst(listaItens);
   }
 }.call();
}

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var inserirItem(@ParamMetaData(description = "idItem") Var idItem, @ParamMetaData(description = "qtde") Var qtde) throws Exception {
 return new Callable<Var>() {

   private Var itemCardapio = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;
   private Var resposta = Var.VAR_NULL;

   public Var call() throws Exception {

    resposta =
    Var.VAR_FALSE;

    try {

        itemCardapio =
        Var.valueOf(getItemCarrinhoPorId(idItem));

        cronapi.database.Operations.insert(Var.valueOf("app.entity.Carrinho"),Var.valueOf("itemCardapio",itemCardapio),Var.valueOf("user",
        Var.valueOf(obterUsuarioLogado())),Var.valueOf("quantidade",qtde),Var.valueOf("valorUnitario",
        cronapi.object.Operations.getObjectField(itemCardapio, Var.valueOf("preco"))));

        resposta =
        Var.VAR_TRUE;
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);

        cronapi.util.Operations.log(
        Var.valueOf("General"),
        Var.valueOf("SEVERE"),
        Var.valueOf(
        Var.valueOf("Erro ao adicionar na sacola\n").toString() +
        exception.toString()), Var.VAR_NULL);
     }
    return resposta;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var listaItensCarrinho() throws Exception {
 return new Callable<Var>() {

   private Var listaItens = Var.VAR_NULL;
   private Var listaRetorno = Var.VAR_NULL;

   public Var call() throws Exception {

    listaItens =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Carrinho"),Var.valueOf("select c from Carrinho c where c.user.normalizedUserName = :userNormalizedUserName"),Var.valueOf("userNormalizedUserName",
    cronapi.text.Operations.normalize(
    Var.valueOf(obterUsuarioLogado()))));

    listaRetorno =
    cronapi.json.Operations.toJson(listaItens);
    return listaRetorno;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var obterUsuarioLogado() throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;

   public Var call() throws Exception {

    lista =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u from User u where u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.text.Operations.normalize(
    cronapi.util.Operations.getCurrentUserName())));
    return
cronapi.list.Operations.getFirst(lista);
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var possuiItens() throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;
   private Var contemProdutos = Var.VAR_NULL;

   public Var call() throws Exception {

    contemProdutos =
    Var.VAR_FALSE;

    lista =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Carrinho"),Var.valueOf("select c from Carrinho c where c.user.normalizedUserName = :userNormalizedUserName"),Var.valueOf("userNormalizedUserName",
    cronapi.text.Operations.normalize(
    cronapi.util.Operations.getCurrentUserName())));

    if (
    Var.valueOf(
    cronapi.list.Operations.size(lista).compareTo(
    Var.valueOf(0)) > 0).getObjectAsBoolean()) {

        contemProdutos =
        Var.VAR_TRUE;
    }
    return contemProdutos;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var totalCarrinho() throws Exception {
 return new Callable<Var>() {

   private Var itemCardapio = Var.VAR_NULL;
   private Var lista = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var total = Var.VAR_NULL;
   private Var subtotal = Var.VAR_NULL;

   public Var call() throws Exception {

    total =
    Var.valueOf(0);

    lista =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Carrinho"),Var.valueOf("select c from Carrinho c where c.user = :user"),Var.valueOf("user",
    Var.valueOf(obterUsuarioLogado())));

    for (Iterator it_i = lista.iterator(); it_i.hasNext();) {
        i = Var.valueOf(it_i.next());

        itemCardapio =
        cronapi.object.Operations.getObjectField(i, Var.valueOf("itemCardapio"));

        subtotal =
        cronapi.math.Operations.multiply(
        cronapi.object.Operations.getObjectField(i, Var.valueOf("quantidade")),
        cronapi.object.Operations.getObjectField(i, Var.valueOf("valorUnitario")));

        total =
        cronapi.math.Operations.sum(total,subtotal);
    } // end for
    return total;
   }
 }.call();
}

}

