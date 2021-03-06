window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.QrCode = window.blockly.js.blockly.QrCode || {};

/**
 * Método que abre o leitor de qr code do dispositivo
 * móvel para ler um qrcode, mostrando uma mensagem em
 * caso de sucesso, e outra em caso de não conseguir ler.
 */
window.blockly.js.blockly.QrCode.EfetuarPagamentoArgs = [];
window.blockly.js.blockly.QrCode.EfetuarPagamento = async function() {
 var item;
  this.cronapi.cordova.camera.qrCodeScanner('QR_CODE', 'Leia o QRCode do estabelecimento para pagar', async function(sender_item) {
      item = sender_item;
    this.cronapi.screen.notify('success','Pagamento Efetuado com sucesso!');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    this.cronapi.screen.notify('success','Erro ao ler QRCode para realizar pagamento');
  }.bind(this));
}
