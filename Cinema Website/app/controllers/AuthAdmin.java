package controllers;

import play.mvc.*;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;

import models.users.*;

public class AuthAdmin extends Action.Simple {

    public CompletionStage<Result> call(Http.Context ctx) {

        String id = ctx.session().get("email");
        if (id != null) {
            User u = User.getUserById(id);
            if ("admin".equals(u.getRole())) {
                // Call the intercepted action method
                return delegate.call(ctx);
            }
        }
        ctx.flash().put("error", "Administrator login required");
        // Redirect to the login page
        return CompletableFuture.completedFuture(redirect(routes.LoginController.login()));
    }
}