window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Restaurante = window.blockly.js.blockly.Restaurante || {};

/**
 * Método para dar funcionalidade ao botão voltar no topo da página do restaurante
 */
window.blockly.js.blockly.Restaurante.voltarArgs = [];
window.blockly.js.blockly.Restaurante.voltar = async function() {

  this.cronapi.screen.back();
}

/**
 * Método criado para converter valores números em
 * float, forçando assim que seja um número e a
 * formatação de máscara em valores monetários funcione.
 */
window.blockly.js.blockly.Restaurante.converteStringEmFloatArgs = ['taxa'];
window.blockly.js.blockly.Restaurante.converteStringEmFloat = async function(taxa) {

  taxaCalculada = (taxa * 1);
  return taxaCalculada;
}

/**
 * Método que obtém as informações do restaurante e seta nos
 * parâmetros da tela de detalhes do restaurante, o seu nome.
 */
window.blockly.js.blockly.Restaurante.inicializarTelaArgs = [];
window.blockly.js.blockly.Restaurante.inicializarTela = async function() {

  item = await this.cronapi.util.callServerBlockly('blockly.Restaurante:getRestaurentePorId', this.cronapi.screen.getValueOfField("params.idRestaurante"));
  this.cronapi.screen.changeValueOfField("vars.nomeRestaurante", this.cronapi.object.getObjectField(item, 'nome'));
}
