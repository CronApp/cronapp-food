package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Restaurante {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Restaurante
public static Var getRestaurantePorUsuario() throws Exception {
 return new Callable<Var>() {

   private Var listRestaurantes = Var.VAR_NULL;
   private Var restauranteLogado = Var.VAR_NULL;

   public Var call() throws Exception {

    listRestaurantes =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u.restaurante from User u where u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.text.Operations.normalize(
    cronapi.util.Operations.getCurrentUserName())));

    restauranteLogado =
    cronapi.list.Operations.getFirst(listRestaurantes);
    return restauranteLogado;
   }
 }.call();
}

}

