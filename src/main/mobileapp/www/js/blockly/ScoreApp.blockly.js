window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ScoreApp = window.blockly.js.blockly.ScoreApp || {};

/**
 * Método responsável por enviar ao servidor a nota informada pelo
 * cliente, e mostrar uma mensagem agradecendo a sua votação.
 */
window.blockly.js.blockly.ScoreApp.avaliarAppArgs = [];
window.blockly.js.blockly.ScoreApp.avaliarApp = async function() {
 var erro, notaAvaliacao, retorno;
  try {
     this.cronapi.screen.showLoading();
    notaAvaliacao = this.cronapi.screen.getValueOfField("params.notaAvaliacaoApp");
    retorno = await this.cronapi.util.callServerBlockly('blockly.FuncoesUsuario:avaliarApp', notaAvaliacao);
    if (retorno) {
      this.cronapi.screen.notify('success','Obrigado pela sua avaliação!');
    }
    this.cronapi.screen.hide();
    await this.blockly.js.blockly.ScoreApp.closeModal();
   } catch (erro_exception) {
        erro = erro_exception;
     this.cronapi.screen.notify('error','Não foi possível registrar sua nota!');
    this.cronapi.screen.hide();
   }
}

/**
 * Método para mostrar a janela com a opção de atribuir uma nota ao app mobile.
 */
window.blockly.js.blockly.ScoreApp.showModalArgs = [];
window.blockly.js.blockly.ScoreApp.showModal = async function() {
 var erro, notaAvaliacao, retorno;
  this.cronapi.screen.showIonicModal("scoreApp");
}

/**
 * Método para fechar a janela que é aberta para a votação da nota do app mobile.
 */
window.blockly.js.blockly.ScoreApp.closeModalArgs = [];
window.blockly.js.blockly.ScoreApp.closeModal = async function() {
 var erro, notaAvaliacao, retorno;
  this.cronapi.screen.hideIonicModal("scoreApp");
}
