window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Search = window.blockly.js.blockly.Search || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Search.buscarArgs = [];
window.blockly.js.blockly.Search.buscar = async function() {

  this.cronapi.screen.changeValueOfField("params.filtrado", 'true');
}

/**
 * Search
 */
window.blockly.js.blockly.Search.ExecutarArgs = [];
window.blockly.js.blockly.Search.Executar = async function() {

}
