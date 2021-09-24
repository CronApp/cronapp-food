window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ProdutoDetalhe = window.blockly.js.blockly.ProdutoDetalhe || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ProdutoDetalhe.adicionarArgs = [];
window.blockly.js.blockly.ProdutoDetalhe.adicionar = async function() {

  await this.cronapi.util.callServerBlocklyNoReturn('blockly.Carrinho:inserirItem', this.cronapi.screen.getValueOfField("params.idProduto"), this.cronapi.screen.getValueOfField("vars.quantidade"));
  this.cronapi.screen.changeView("#/app/logged/carrinho",[  ]);
}

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
window.blockly.js.blockly.ProdutoDetalhe.mostraRestauranteArgs = ['idProduto'];
window.blockly.js.blockly.ProdutoDetalhe.mostraRestaurante = async function(idProduto) {

  item = await this.cronapi.util.callServerBlockly('blockly.Restaurante:getRestaurantePorIdProduto', idProduto);
  console.log(String('RECEBIDO:') + String(item));
  this.cronapi.screen.changeView("#/app/logged/restaurante-produtos",[ { categoriaRestaurante : null } , { idRestaurante : this.cronapi.json.getProperty(item, 'id') } , { logotipoRestaurante : this.cronapi.json.getProperty(item, 'logotipoRestaurante') } , { nomeRestaurante : this.cronapi.json.getProperty(item, 'nome') } , { taxaEntregaRestaurante : this.cronapi.json.getProperty(item, 'taxaEntrega') } , { tempoEntregaRestaurante : this.cronapi.json.getProperty(item, 'tempoEntrega') } ]);
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

  this.cronapi.screen.changeValueOfField("vars.quantidade", 1);
}
