window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Home = window.blockly.js.blockly.Home || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Home.initTelaArgs = [];
window.blockly.js.blockly.Home.initTela = async function() {

  this.cronapi.screen.changeValueOfField("params.exibeBotaoSacola", await this.cronapi.util.callServerBlockly('blockly.Carrinho:possuiItens'));
  this.cronapi.screen.changeValueOfField("params.valorTotalSacola", await this.cronapi.util.callServerBlockly('blockly.Carrinho:totalCarrinho'));
}
