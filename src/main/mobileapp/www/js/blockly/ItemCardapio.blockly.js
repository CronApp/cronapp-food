window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ItemCardapio = window.blockly.js.blockly.ItemCardapio || {};

/**
 * Método utilizado para que o botão de retornar no topo
 * da tela do produto no app mobile volte a tela anterior
 */
window.blockly.js.blockly.ItemCardapio.voltarArgs = [];
window.blockly.js.blockly.ItemCardapio.voltar = async function() {

  this.cronapi.screen.back();
}
