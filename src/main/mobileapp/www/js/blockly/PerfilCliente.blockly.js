window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.PerfilCliente = window.blockly.js.blockly.PerfilCliente || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.PerfilCliente.sairDoSistemaArgs = [];
window.blockly.js.blockly.PerfilCliente.sairDoSistema = async function() {
 var notaAvaliacao, retorno;
  this.cronapi.screen.logout();
}

/**
 * PerfilCliente
 */
window.blockly.js.blockly.PerfilCliente.definirUsuarioLogadoArgs = [];
window.blockly.js.blockly.PerfilCliente.definirUsuarioLogado = async function() {
 var notaAvaliacao, retorno;
  usuarioLogado = await this.cronapi.util.callServerBlockly('blockly.FuncoesUsuario:obterUsuarioLogado');
  this.cronapi.screen.changeValueOfField("params.nomeUsuarioLogado", this.cronapi.object.getProperty(usuarioLogado, 'name'));
  this.cronapi.screen.changeValueOfField("params.emailUsuarioLogado", this.cronapi.object.getProperty(usuarioLogado, 'email'));
  this.cronapi.screen.changeValueOfField("params.telefoneUsuarioLogado", this.cronapi.object.getProperty(usuarioLogado, 'phoneNumber'));
  this.cronapi.screen.changeValueOfField("params.notaAvaliacaoApp", this.cronapi.object.getProperty(usuarioLogado, 'avaliacaoApp'));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.PerfilCliente.avaliarAppArgs = [];
window.blockly.js.blockly.PerfilCliente.avaliarApp = async function() {
 var notaAvaliacao, retorno;
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
