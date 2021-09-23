window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.FinalizaPedido = window.blockly.js.blockly.FinalizaPedido || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.FinalizaPedido.finalizarPedidoArgs = [];
window.blockly.js.blockly.FinalizaPedido.finalizarPedido = async function() {
 var retornoCep;
  await this.cronapi.util.callServerBlocklyNoReturn('blockly.Carrinho:fecharPedido', this.cronapi.screen.getValueOfField("FormaPagamento.active.id"), this.cronapi.screen.getValueOfField("vars.cep"), this.cronapi.screen.getValueOfField("vars.rua"), this.cronapi.screen.getValueOfField("vars.numero"), this.cronapi.screen.getValueOfField("vars.bairro"), this.cronapi.screen.getValueOfField("vars.cidade"), this.cronapi.screen.getValueOfField("vars.uf"));
  this.cronapi.screen.changeView("#/app/logged/home-pedidos",[ { teste : null } ]);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.FinalizaPedido.buscaCepArgs = [];
window.blockly.js.blockly.FinalizaPedido.buscaCep = async function() {
 var retornoCep;
  this.cronapi.util.getCEP(this.cronapi.screen.getValueOfField("vars.cep"), async function(sender_retornoCep) {
      retornoCep = sender_retornoCep;
    this.cronapi.screen.changeValueOfField("vars.rua", this.cronapi.object.getProperty(retornoCep, 'logradouro'));
    this.cronapi.screen.changeValueOfField("vars.bairro", this.cronapi.object.getProperty(retornoCep, 'bairro'));
    this.cronapi.screen.changeValueOfField("vars.cidade", this.cronapi.object.getProperty(retornoCep, 'localidade'));
    this.cronapi.screen.changeValueOfField("vars.uf", this.cronapi.object.getProperty(retornoCep, 'uf'));
  }.bind(this));
}
