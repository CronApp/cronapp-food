window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Search = window.blockly.js.blockly.Search || {};

/**
 * Método criado para alterar a visibilidade das abas que
 * mostram o resultado da busca na tela do app mobile.
 */
window.blockly.js.blockly.Search.buscarArgs = [];
window.blockly.js.blockly.Search.buscar = async function() {

  this.cronapi.screen.changeValueOfField("params.filtrado", 'true');
}
