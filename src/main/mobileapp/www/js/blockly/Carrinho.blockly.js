window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Carrinho = window.blockly.js.blockly.Carrinho || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Carrinho.mostraTotalCarrinhoArgs = [];
window.blockly.js.blockly.Carrinho.mostraTotalCarrinho = async function() {

  this.cronapi.screen.changeValueOfField("vars.valorTotal", await this.cronapi.util.callServerBlockly('blockly.Carrinho:totalCarrinho'));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Carrinho.esvaziarCarrinhoArgs = [];
window.blockly.js.blockly.Carrinho.esvaziarCarrinho = async function() {

  await this.cronapi.util.callServerBlocklyNoReturn('blockly.Carrinho:esvaziarCarrinho');
  this.cronapi.screen.changeView("#/app/logged/home",[  ]);
}
