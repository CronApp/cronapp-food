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

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Carrinho.inserirItemArgs = ['idItem', 'qtde'];
window.blockly.js.blockly.Carrinho.inserirItem = async function(idItem, qtde) {

  await this.blockly.js.blockly.Carrinho.abreSacola();
  await this.cronapi.util.callServerBlocklyNoReturn('blockly.Carrinho:inserirItem', idItem, qtde);
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

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Carrinho.abreSacolaArgs = [];
window.blockly.js.blockly.Carrinho.abreSacola = async function() {

  this.cronapi.screen.createScopeVariable('carrinhoComItens', true);
}
