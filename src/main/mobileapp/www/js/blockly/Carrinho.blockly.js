window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Carrinho = window.blockly.js.blockly.Carrinho || {};

/**
 * Carrinho
 */
window.blockly.js.blockly.Carrinho.definirLoginUsuarioArgs = [];
window.blockly.js.blockly.Carrinho.definirLoginUsuario = async function() {

  this.cronapi.screen.changeValueOfField("params.usuarioLogado", await this.cronapi.util.callServerBlockly('blockly.FuncoesUsuario:LoginDoUsuario'));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Carrinho.initTelaComTotaisArgs = [];
window.blockly.js.blockly.Carrinho.initTelaComTotais = async function() {

  this.cronapi.screen.changeValueOfField("params.totalFrete", await this.cronapi.util.callServerBlockly('blockly.Carrinho:totalFreteCarrinho'));
  this.cronapi.screen.changeValueOfField("params.totalItens", await this.cronapi.util.callServerBlockly('blockly.Carrinho:totalCarrinho'));
}
