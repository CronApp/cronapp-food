window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.auth = window.blockly.js.blockly.auth || {};
window.blockly.js.blockly.auth.FuncoesUsuario = window.blockly.js.blockly.auth.FuncoesUsuario || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.auth.FuncoesUsuario.getLoginUsuarioLogadoArgs = [];
window.blockly.js.blockly.auth.FuncoesUsuario.getLoginUsuarioLogado = async function() {

  return await this.cronapi.util.callServerBlockly('blockly.FuncoesUsuario:LoginDoUsuario');
}
