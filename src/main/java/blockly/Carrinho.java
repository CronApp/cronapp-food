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
 *
 * Descreva esta função...
 *
 * @author Root
 * @since 6/27/2024, 3:43:57 PM
 *
 */
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
 * Descreva esta função...
 *
 * @param formaPagamento
 * @param cep
 * @param logradouro
 * @param numero
 * @param bairro
 * @param cidade
 * @param uf
 *
 * @author Root
 * @since 6/27/2024, 3:43:57 PM
 *
 */
public static Var fecharPedido(@ParamMetaData(description = "formaPagamento", id = "2ae8739b") Var formaPagamento, @ParamMetaData(description = "cep", id = "73e548d8") Var cep, @ParamMetaData(description = "logradouro", id = "91b2493e") Var logradouro, @ParamMetaData(description = "numero", id = "e32123b6") Var numero, @ParamMetaData(description = "bairro", id = "58d20383") Var bairro, @ParamMetaData(description = "cidade", id = "4ff824ba") Var cidade, @ParamMetaData(description = "uf", id = "c7a871c2") Var uf) throws Exception {
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
        cronapi.database.Operations.query(Var.valueOf("app.entity.Carrinho"),Var.valueOf("select distinct c.itemCardapio.restaurante from Carrinho c where c.user = :user"),Var.valueOf("user",
        Var.valueOf(obterUsuarioLogado())));
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
                cronapi.object.Operations.getObjectField(itemCarrinho, Var.valueOf("quantidade"))),Var.valueOf("valorUnitario",
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
 * Descreva esta função...
 *
 * @param idItem
 *
 * @author Root
 * @since 6/27/2024, 3:43:57 PM
 *
 */
public static Var getItemCarrinhoPorId(@ParamMetaData(description = "idItem", id = "2260f641") Var idItem) throws Exception {
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
 * Descreva esta função...
 *
 * @param idItem
 * @param qtde
 *
 * @author Root
 * @since 6/27/2024, 3:43:57 PM
 *
 */
public static Var inserirItem(@ParamMetaData(description = "idItem", id = "5386d093") Var idItem, @ParamMetaData(description = "qtde", id = "a30b433c") Var qtde) throws Exception {
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
        Var.valueOf("Erro ao adicionar na sacola\n").getObjectAsString() +
        exception.getObjectAsString()), Var.VAR_NULL);
     }
    return resposta;
   }
 }.call();
}

/**
 *
 * Método criado para consultar no banco de dados os itens que estão no carrinho do usuário atual, e retornar um JSON para ser utilizado na aplicação mobile
 *
 * @author Root
 * @since 6/27/2024, 3:43:57 PM
 *
 */
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
 * Método que retorna o objeto que representa o usuário logado no sistema.
 *
 * @author Root
 * @since 6/27/2024, 3:43:57 PM
 *
 */
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
 * Método que consulta os itens do carrinho no banco de dados, e se a lista retornada for maior que zero, informa que o carrinho possui itens, se a quantidade for zero, retorna que não possui. Método utilizado para exibir ou não o botão da sacola no app mobile.
 *
 * @author Root
 * @since 6/27/2024, 3:43:57 PM
 *
 */
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
 * Descreva esta função...
 *
 * @author Root
 * @since 6/27/2024, 3:43:57 PM
 *
 */
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

/**
 *
 * Método que Calcula o total do frete do carrinho. Como no carrinho podem ser adicionados produtos de mais de um restaurante, ele faz uma consulta dos restaurantes existentes no carrinho e posteriormente varre o resultado somando o frete dos restaurantes para obter o total.
 *
 * @author Root
 * @since 6/27/2024, 3:43:57 PM
 *
 */
public static Var totalFreteCarrinho() throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var total = Var.VAR_NULL;

   public Var call() throws Exception {
    total =
    Var.valueOf(0);
    lista =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Carrinho"),Var.valueOf("select distinct c.itemCardapio.restaurante from Carrinho c where c.user = :user"),Var.valueOf("user",
    Var.valueOf(obterUsuarioLogado())));
    for (Iterator it_i = lista.iterator(); it_i.hasNext();) {
        i = Var.valueOf(it_i.next());
        total =
        cronapi.math.Operations.sum(total,
        cronapi.object.Operations.getObjectField(i, Var.valueOf("taxaEntrega")));
    } // end for
    return total;
   }
 }.call();
}

public static Var exibirAviso() throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;

   public Var call() throws Exception {
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("warning"),Var.valueOf("Sacola está vazia."));
    return lista;
   }
 }.call();
}



}

