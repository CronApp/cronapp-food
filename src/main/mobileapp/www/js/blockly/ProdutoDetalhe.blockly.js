window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ProdutoDetalhe = window.blockly.js.blockly.ProdutoDetalhe || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ProdutoDetalhe.voltarArgs = [];
window.blockly.js.blockly.ProdutoDetalhe.voltar = async function() {

  this.cronapi.screen.back();
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ProdutoDetalhe.adicionarArgs = [];
window.blockly.js.blockly.ProdutoDetalhe.adicionar = async function() {

  if (this.cronapi.screen.getValueOfField("vars.quantidade") > 0) {
    await this.cronapi.util.callServerBlocklyNoReturn('blockly.Carrinho:inserirItem', this.cronapi.screen.getValueOfField("params.idProduto"), this.cronapi.screen.getValueOfField("vars.quantidade"));
    this.cronapi.screen.changeView("#/app/logged/carrinho",[  ]);
  } else {
    this.cronapi.screen.notify('warning','A quantidade mínima para adicionar é 1');
  }
}

/**
 * Método criado para converter valores números em
 * float, forçando assim que seja um número e a
 * formatação de máscara em valores monetários funcione.
 */
window.blockly.js.blockly.ProdutoDetalhe.converteStringEmFloatArgs = ['valor'];
window.blockly.js.blockly.ProdutoDetalhe.converteStringEmFloat = async function(valor) {

  retorno = (valor * 1);
  return retorno;
}

/**
 * Método criado para definir sempre que a tela de detalhe do
 * produto é aberta que o campo quantidade receba o valor 1
 */
window.blockly.js.blockly.ProdutoDetalhe.inicializaTelaArgs = [];
window.blockly.js.blockly.ProdutoDetalhe.inicializaTela = async function() {

  this.cronapi.screen.changeValueOfField("vars.quantidade", 1);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ProdutoDetalhe.obterTotalItemArgs = [];
window.blockly.js.blockly.ProdutoDetalhe.obterTotalItem = async function() {

  quantidade = await this.blockly.js.blockly.ProdutoDetalhe.converteStringEmFloat(this.cronapi.screen.getValueOfField("vars.quantidade"));
  valorUnitario = await this.blockly.js.blockly.ProdutoDetalhe.converteStringEmFloat(this.cronapi.screen.getValueOfField("params.precoProduto"));
  valorTotal = (quantidade * valorUnitario);
  return valorTotal;
}
