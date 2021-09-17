window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.auth = window.blockly.js.blockly.auth || {};
window.blockly.js.blockly.auth.ChangePersonData = window.blockly.js.blockly.auth.ChangePersonData || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.auth.ChangePersonData.changePersonDataArgs = [];
window.blockly.js.blockly.auth.ChangePersonData.changePersonData = async function() {
 var erro, resultado;
  try {
     this.cronapi.screen.showLoading();
    resultado = await this.cronapi.util.callServerBlockly('blockly.FuncoesUsuario:updatePersonData', this.cronapi.screen.getValueOfField("params.nomeUsuarioLogado"), this.cronapi.screen.getValueOfField("params.emailUsuarioLogado"), this.cronapi.screen.getValueOfField("params.telefoneUsuarioLogado"));
    this.cronapi.screen.hide();
    if (resultado) {
      this.cronapi.screen.notify('success','Dados atualizados com sucesso!');
      await this.blockly.js.blockly.auth.ChangePersonData.closeModal();
    } else {
      this.cronapi.screen.notify('error','Ocorreu um erro ao atualizar dados!');
    }
   } catch (erro_exception) {
        erro = erro_exception;
     this.cronapi.screen.hide();
   }
}

/**
 * ChangePassword
 */
window.blockly.js.blockly.auth.ChangePersonData.openModalArgs = [];
window.blockly.js.blockly.auth.ChangePersonData.openModal = async function() {
 var erro, resultado;
  this.cronapi.screen.showIonicModal("changePersonData");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.auth.ChangePersonData.closeModalArgs = [];
window.blockly.js.blockly.auth.ChangePersonData.closeModal = async function() {
 var erro, resultado;
  this.cronapi.screen.hideIonicModal("changePersonData");
}
