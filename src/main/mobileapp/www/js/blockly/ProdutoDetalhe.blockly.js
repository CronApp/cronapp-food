window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ProdutoDetalhe = window.blockly.js.blockly.ProdutoDetalhe || {};

/**
 * ProdutoDetalhe
 */
window.blockly.js.blockly.ProdutoDetalhe.obterTotalItemArgs = [];
window.blockly.js.blockly.ProdutoDetalhe.obterTotalItem = async function() {
 var qtde, valorUnit, valorTotal;
  qtde = this.cronapi.screen.getValueOfField("vars.quantidade");
  valorUnit = this.cronapi.screen.getValueOfField("params.valorProduto");
  valorTotal = (qtde * valorUnit);
  return String('Adicionar - R$ ') + String(valorTotal);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ProdutoDetalhe.inicializaTelaArgs = [];
window.blockly.js.blockly.ProdutoDetalhe.inicializaTela = async function() {
 var qtde, valorUnit, valorTotal;
  this.cronapi.screen.changeValueOfField("vars.quantidade", 1);
}
