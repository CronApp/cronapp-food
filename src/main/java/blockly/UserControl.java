package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class UserControl {

public static final int TIMEOUT = 300;

/**
 *
 * Descreva esta função...
 *
 * @param email
 *
 * @author Root
 * @since 01/06/2022 11:52:42
 *
 */
public static Var resetPassword(@ParamMetaData(description = "email", id = "53fc1de9") Var email) throws Exception {
 return new Callable<Var>() {

   private Var httpReturnStatus = Var.VAR_NULL;
   private Var username = Var.VAR_NULL;
   private Var password = Var.VAR_NULL;
   private Var error = Var.VAR_NULL;

   public Var call() throws Exception {
    return
cronapi.authentication.Operations.defaultResetPassword(email,
Var.valueOf("https://acesso.cronapp.io/img/header.png"),
Var.valueOf("https://acesso.cronapp.io/img/footer.png"),
Var.VAR_FALSE);
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @param username
 * @param email
 * @param password
 *
 * @author Root
 * @since 01/06/2022 11:52:42
 *
 */
public static Var signUp(@ParamMetaData(description = "username", id = "b7d52451") Var username, @ParamMetaData(description = "email", id = "36bc1157") Var email, @ParamMetaData(description = "password", id = "097625e0") Var password) throws Exception {
 return new Callable<Var>() {

   private Var httpReturnStatus = Var.VAR_NULL;
   private Var error = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         httpReturnStatus =
        cronapi.authentication.Operations.signUp(
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("username",username) , Var.valueOf("name",username) , Var.valueOf("email",email) , Var.valueOf("password",password)));
     } catch (Exception error_exception) {
          error = Var.valueOf(error_exception);
         cronapi.util.Operations.log(
        Var.valueOf("General"),
        Var.valueOf("SEVERE"),
        cronapi.json.Operations.getJsonOrMapField(error,
        Var.valueOf("message")), error);
     }
    return httpReturnStatus;
   }
 }.call();
}

}

