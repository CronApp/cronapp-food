window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Restaurante = window.blockly.js.blockly.Restaurante || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Restaurante.voltarArgs = [];
window.blockly.js.blockly.Restaurante.voltar = async function() {
 var item;
  this.cronapi.screen.back();
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Restaurante.inicializarTelaArgs = [];
window.blockly.js.blockly.Restaurante.inicializarTela = async function() {
 var item;
  item = await this.cronapi.util.callServerBlockly('blockly.Restaurante:getRestaurentePorId', this.cronapi.screen.getValueOfField("params.idRestaurante"));
  this.cronapi.screen.changeValueOfField("vars.nomeRestaurante", this.cronapi.object.getObjectField(item, 'nome'));
}
