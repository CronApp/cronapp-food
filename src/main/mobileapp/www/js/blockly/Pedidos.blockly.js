window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Pedidos = window.blockly.js.blockly.Pedidos || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedidos.initTelaArgs = [];
window.blockly.js.blockly.Pedidos.initTela = async function() {

  this.cronapi.screen.changeValueOfField("params.exibeBotaoSacola", await this.cronapi.util.callServerBlockly('blockly.Carrinho:possuiItens'));
  this.cronapi.screen.changeValueOfField("params.valorTotalSacola", await this.cronapi.util.callServerBlockly('blockly.Carrinho:totalCarrinho'));
}
