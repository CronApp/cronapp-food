window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Restaurante = window.blockly.js.blockly.Restaurante || {};

/**
 * Restaurante
 */
window.blockly.js.blockly.Restaurante.getRestauranteLogadoArgs = [];
window.blockly.js.blockly.Restaurante.getRestauranteLogado = async function() {

  return await this.cronapi.util.callServerBlockly('blockly.Restaurante:getRestaurantePorUsuario');
}
