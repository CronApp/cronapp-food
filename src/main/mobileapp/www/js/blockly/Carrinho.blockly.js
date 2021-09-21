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
