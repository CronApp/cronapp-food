window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Restaurante = window.blockly.js.blockly.Restaurante || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Restaurante.voltarArgs = [];
window.blockly.js.blockly.Restaurante.voltar = async function() {
 var taxa, taxaCalculada;
  this.cronapi.screen.back();
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Restaurante.converteStringEmFloatArgs = ['taxa'];
window.blockly.js.blockly.Restaurante.converteStringEmFloat = async function(taxa) {
 var taxaCalculada;
  taxaCalculada = (taxa * 1);
  return taxaCalculada;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Restaurante.inicializarTelaArgs = [];
window.blockly.js.blockly.Restaurante.inicializarTela = async function() {
 var taxa, taxaCalculada;
  item = await this.cronapi.util.callServerBlockly('blockly.Restaurante:getRestaurentePorId', this.cronapi.screen.getValueOfField("params.idRestaurante"));
  this.cronapi.screen.changeValueOfField("vars.nomeRestaurante", this.cronapi.object.getObjectField(item, 'nome'));
}
