window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.PerfilCliente = window.blockly.js.blockly.PerfilCliente || {};

/**
 * Método criado para efetuar o logout do sistema no app mobile.
 */
window.blockly.js.blockly.PerfilCliente.sairDoSistemaArgs = [];
window.blockly.js.blockly.PerfilCliente.sairDoSistema = async function() {

  this.cronapi.screen.logout();
}

/**
 * Método responsável por obter as informações do us a partir do banco de dados
 */
window.blockly.js.blockly.PerfilCliente.definirUsuarioLogadoArgs = [];
window.blockly.js.blockly.PerfilCliente.definirUsuarioLogado = async function() {

  usuarioLogado = await this.cronapi.util.callServerBlockly('blockly.FuncoesUsuario:obterUsuarioLogado');
  this.cronapi.screen.changeValueOfField("params.nomeUsuarioLogado", this.cronapi.object.getProperty(usuarioLogado, 'name'));
  this.cronapi.screen.changeValueOfField("params.emailUsuarioLogado", this.cronapi.object.getProperty(usuarioLogado, 'email'));
  this.cronapi.screen.changeValueOfField("params.telefoneUsuarioLogado", this.cronapi.object.getProperty(usuarioLogado, 'phoneNumber'));
  this.cronapi.screen.changeValueOfField("params.notaAvaliacaoApp", this.cronapi.object.getProperty(usuarioLogado, 'avaliacaoApp'));
}

/**
 * Método que registra a nota de avaliação do cliente em
 * relação ao uso do app mobile. Este método invoca o bloco
 * no servidor para registrar no banco de dados essa nota.
 */
window.blockly.js.blockly.PerfilCliente.avaliarAppArgs = [];
window.blockly.js.blockly.PerfilCliente.avaliarApp = async function() {

  try {
     this.cronapi.screen.showLoading();
    notaAvaliacao = this.cronapi.screen.getValueOfField("params.notaAvaliacaoApp");
    retorno = await this.cronapi.util.callServerBlockly('blockly.FuncoesUsuario:avaliarApp', notaAvaliacao);
    if (retorno) {
      this.cronapi.screen.notify('success','Obrigado pela sua avaliação!');
    }
    this.cronapi.screen.hide();
   } catch (ex1_exception) {
          this.cronapi.screen.hide();
   } finally {
   }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.PerfilCliente.initTelaArgs = [];
window.blockly.js.blockly.PerfilCliente.initTela = async function() {

  this.cronapi.screen.changeValueOfField("params.exibeBotaoSacola", await this.cronapi.util.callServerBlockly('blockly.Carrinho:possuiItens'));
  this.cronapi.screen.changeValueOfField("params.valorTotalSacola", await this.cronapi.util.callServerBlockly('blockly.Carrinho:totalCarrinho'));
}
