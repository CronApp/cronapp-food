window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Carrinho = window.blockly.js.blockly.Carrinho || {};

/**
 * Carrinho
 */
window.blockly.js.blockly.Carrinho.definirLoginUsuarioArgs = [];
window.blockly.js.blockly.Carrinho.definirLoginUsuario = async function() {
 var totalItens, totalFrete, totalCompra;
  this.cronapi.screen.changeValueOfField("params.usuarioLogado", await this.cronapi.util.callServerBlockly('blockly.FuncoesUsuario:LoginDoUsuario'));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Carrinho.inserirItemArgs = ['idItem', 'qtde'];
window.blockly.js.blockly.Carrinho.inserirItem = async function(idItem, qtde) {
 var totalItens;
  await this.blockly.js.blockly.Carrinho.abreSacola();
  await this.blockly.blockly.Carrinho.inserirItem('blockly.blockly.Carrinho.inserirItem', idItem, qtde);
}

/**
 * Método invocado na inicialização da tela da sacola, atualizando a
 * partir do servidor o valor do frete e o total dos itens do carrinho
 */
window.blockly.js.blockly.Carrinho.initTelaComTotaisArgs = [];
window.blockly.js.blockly.Carrinho.initTelaComTotais = async function() {
 var totalItens, totalFrete, totalCompra;
  totalItens = await this.cronapi.util.callServerBlockly('blockly.Carrinho:totalCarrinho');
  totalFrete = await this.cronapi.util.callServerBlockly('blockly.Carrinho:totalFreteCarrinho');
  totalCompra = (totalItens + totalFrete);
  this.cronapi.screen.changeValueOfField("params.totalFrete", totalFrete);
  this.cronapi.screen.changeValueOfField("params.totalItens", totalItens);
  this.cronapi.screen.changeValueOfField("params.totalCompra", totalCompra);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Carrinho.abreSacolaArgs = [];
window.blockly.js.blockly.Carrinho.abreSacola = async function() {
 var totalItens, totalFrete, totalCompra;
  this.cronapi.screen.createScopeVariable('carrinhoComItens', true);
}
