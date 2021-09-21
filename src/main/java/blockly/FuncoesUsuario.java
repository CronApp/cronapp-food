package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class FuncoesUsuario {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// FuncoesUsuario
public static Var LoginDoUsuario() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.text.Operations.normalize(
cronapi.util.Operations.getCurrentUserName());
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var IdDoUsuarioLogado() throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;

   public Var call() throws Exception {

    lista =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u.id from User u where u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.text.Operations.normalize(
    Var.valueOf(LoginDoUsuario()))));
    return
cronapi.list.Operations.getFirst(lista);
   }
 }.call();
}

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var avaliarApp(@ParamMetaData(description = "nota") Var nota) throws Exception {
 return new Callable<Var>() {

   private Var retorno = Var.VAR_NULL;
   private Var usuarioAtual = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;

   public Var call() throws Exception {

    retorno =
    Var.VAR_FALSE;

    try {

        usuarioAtual =
        Var.valueOf(obterUsuarioLogado());

        cronapi.object.Operations.setObjectField(usuarioAtual, Var.valueOf("avaliacaoApp"), nota);

        cronapi.database.Operations.update(Var.valueOf("app.entity.User"),usuarioAtual);

        retorno =
        Var.VAR_TRUE;
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);

     }
    return retorno;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var obterLoginUsuario() throws Exception {
 return new Callable<Var>() {

   private Var retorno = Var.VAR_NULL;
   private Var usuarioAtual = Var.VAR_NULL;
   private Var nota = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;
   private Var lista = Var.VAR_NULL;
   private Var resultado = Var.VAR_NULL;
   private Var name = Var.VAR_NULL;
   private Var email = Var.VAR_NULL;
   private Var phoneNumber = Var.VAR_NULL;

   public Var call() throws Exception {
    return
cronapi.util.Operations.getCurrentUserName();
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var obterUsuarioLogado() throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;

   public Var call() throws Exception {

    lista =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u from User u where u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    Var.valueOf(LoginDoUsuario())));
    return
cronapi.list.Operations.getFirst(lista);
   }
 }.call();
}

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// Descreva esta função...
public static Var updatePersonData(@ParamMetaData(description = "name") Var name, @ParamMetaData(description = "email") Var email, @ParamMetaData(description = "phoneNumber") Var phoneNumber) throws Exception {
 return new Callable<Var>() {

   private Var usuarioAtual = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;
   private Var resultado = Var.VAR_NULL;

   public Var call() throws Exception {

    resultado =
    Var.VAR_FALSE;

    if (
    Var.valueOf(
    /*# sourceMappingStart=(x?EpCL-#Hz+bpRQ=r-a */
    cronapi.logic.Operations.isNullOrEmpty(name).negate().getObjectAsBoolean() &&
    /*# sourceMappingStart=9SHu/D`j0T2(dGE9Wp`A */
    cronapi.logic.Operations.isNullOrEmpty(email).negate().getObjectAsBoolean()).getObjectAsBoolean()) {

        usuarioAtual =
        Var.valueOf(obterUsuarioLogado());

        cronapi.object.Operations.setObjectField(usuarioAtual, Var.valueOf("name"), name);

        cronapi.object.Operations.setObjectField(usuarioAtual, Var.valueOf("email"), email);

        cronapi.object.Operations.setObjectField(usuarioAtual, Var.valueOf("normalizedEmail"),
        cronapi.text.Operations.normalize(email));

        cronapi.object.Operations.setObjectField(usuarioAtual, Var.valueOf("phoneNumber"), phoneNumber);

        try {

            cronapi.database.Operations.update(Var.valueOf("app.entity.User"),usuarioAtual);

            resultado =
            Var.VAR_TRUE;
         } catch (Exception erro_exception) {
              erro = Var.valueOf(erro_exception);

         }
    }
    return resultado;
   }
 }.call();
}

}

