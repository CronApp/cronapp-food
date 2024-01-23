window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.FinalizaPedido = window.blockly.js.blockly.FinalizaPedido || {};

/**
 * @function finalizarPedido
 *
 * Método responsável por invocar o bloco no servidor, passando
 * os parâmetros necessários para que o pedido seja finalizado
 *
 *
 * @author Igor Andrade
 * @since 23/01/2024, 12:39:10
 *
 */
window.blockly.js.blockly.FinalizaPedido.finalizarPedidoArgs = [];
window.blockly.js.blockly.FinalizaPedido.finalizarPedido = async function() {
 var pedidoFechado;
  //
  pedidoFechado = (await this.cronapi.server('blockly.Carrinho.fecharPedido').toPromise().run(this.cronapi.screen.getValueOfField("FormaPagamento.active.id"), this.cronapi.screen.getValueOfField("vars.cep"), this.cronapi.screen.getValueOfField("vars.rua"), this.cronapi.screen.getValueOfField("vars.numero"), this.cronapi.screen.getValueOfField("vars.bairro"), this.cronapi.screen.getValueOfField("vars.cidade"), this.cronapi.screen.getValueOfField("vars.uf")));
  //
  if (pedidoFechado) {
    //
    this.cronapi.screen.changeView("#/app/logged/home-pedidos",[ { exibeBotaoSacola : false } , { teste : null } , { valorTotalSacola : null } ]);
  } else {
    //
    this.cronapi.screen.notify('error',this.cronapi.i18n.translate("FinalizaPedidoBlockly.erro",[  ]));
  }
}

/**
 * @function buscaCep
 *
 * Método invocado na tela de finalização para buscar
 * o endereço do cliente a partir do CEP informado.
 *
 *
 * @author Igor Andrade
 * @since 23/01/2024, 12:39:10
 *
 */
window.blockly.js.blockly.FinalizaPedido.buscaCepArgs = [];
window.blockly.js.blockly.FinalizaPedido.buscaCep = async function() {
 var pedidoFechado;
  //
  this.cronapi.util.getCEP(this.cronapi.screen.getValueOfField("vars.cep"), async function(sender_retornoCep) {
      retornoCep = sender_retornoCep;
    //
    this.cronapi.screen.changeValueOfField("vars.rua", this.cronapi.object.getProperty(retornoCep, 'logradouro'));
    //
    this.cronapi.screen.changeValueOfField("vars.bairro", this.cronapi.object.getProperty(retornoCep, 'bairro'));
    //
    this.cronapi.screen.changeValueOfField("vars.cidade", this.cronapi.object.getProperty(retornoCep, 'localidade'));
    //
    this.cronapi.screen.changeValueOfField("vars.uf", this.cronapi.object.getProperty(retornoCep, 'uf'));
  }.bind(this));
}

/**
 * @function initTela
 *
 * Descreva esta função...
 *
 *
 * @author Igor Andrade
 * @since 23/01/2024, 12:39:10
 *
 */
window.blockly.js.blockly.FinalizaPedido.initTelaArgs = [];
window.blockly.js.blockly.FinalizaPedido.initTela = async function() {
 var pedidoFechado;
  //
  totalItens = (await this.cronapi.server('blockly.Carrinho.totalCarrinho').toPromise().run());
  //
  totalFrete = (await this.cronapi.server('blockly.Carrinho.totalFreteCarrinho').toPromise().run());
  //
  totalPedido = (totalFrete + totalItens);
  //
  this.cronapi.screen.changeValueOfField("vars.totalPedido", totalPedido);
}
