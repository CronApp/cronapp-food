window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ProdutoDetalhe = window.blockly.js.blockly.ProdutoDetalhe || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ProdutoDetalhe.adicionarArgs = [];
window.blockly.js.blockly.ProdutoDetalhe.adicionar = async function() {
 var idProduto;
  await this.cronapi.util.callServerBlocklyNoReturn('blockly.Carrinho:inserirItem', this.cronapi.screen.getValueOfField("params.idProduto"), this.cronapi.screen.getValueOfField("vars.quantidade"));
  this.cronapi.screen.changeView("#/app/logged/carrinho",[  ]);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ProdutoDetalhe.voltarArgs = [];
window.blockly.js.blockly.ProdutoDetalhe.voltar = async function() {
 var idProduto;
  this.cronapi.screen.back();
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ProdutoDetalhe.getLogoRestauranteArgs = ['idProduto'];
window.blockly.js.blockly.ProdutoDetalhe.getLogoRestaurante = async function(idProduto) {

  return String('data:image/jpg;base64,') + String(await this.cronapi.util.callServerBlockly('blockly.Restaurante:getLogoRestaurante', idProduto));
}

/**
 * ProdutoDetalhe
 */
window.blockly.js.blockly.ProdutoDetalhe.obterTotalItemArgs = [];
window.blockly.js.blockly.ProdutoDetalhe.obterTotalItem = async function() {
 var idProduto;
  qtde = this.cronapi.screen.getValueOfField("vars.quantidade");
  valorUnit = this.cronapi.screen.getValueOfField("params.valorProduto");
  valorTotal = (qtde * valorUnit);
  return valorTotal;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ProdutoDetalhe.inicializaTelaArgs = [];
window.blockly.js.blockly.ProdutoDetalhe.inicializaTela = async function() {
 var idProduto;
  this.cronapi.screen.changeValueOfField("vars.quantidade", 1);
}
