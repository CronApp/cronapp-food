window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Carrinho = window.blockly.js.blockly.Carrinho || {};

/**
 * Método criado para definir no parâmetro da tela
 * do carrinho o usuário logado no sistema, chamando
 * um bloco do servidor para obter essa informação.
 */
window.blockly.js.blockly.Carrinho.definirLoginUsuarioArgs = [];
window.blockly.js.blockly.Carrinho.definirLoginUsuario = async function() {

  this.cronapi.screen.changeValueOfField("params.usuarioLogado", await this.cronapi.util.callServerBlockly('blockly.FuncoesUsuario:LoginDoUsuario'));
}

/**
 * Método invocado na inicialização da tela da sacola, atualizando a
 * partir do servidor o valor do frete e o total dos itens do carrinho
 */
window.blockly.js.blockly.Carrinho.initTelaComTotaisArgs = [];
window.blockly.js.blockly.Carrinho.initTelaComTotais = async function() {

  this.cronapi.screen.changeValueOfField("params.totalFrete", await this.cronapi.util.callServerBlockly('blockly.Carrinho:totalFreteCarrinho'));
  this.cronapi.screen.changeValueOfField("params.totalItens", await this.cronapi.util.callServerBlockly('blockly.Carrinho:totalCarrinho'));
}
