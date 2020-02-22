package com.kush.app;

import com.kush.app.api.ReceiverVerticle;
import com.kush.app.api.SenderVerticle;
import com.kush.app.ui.RoutingHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class DeployerVerticle extends AbstractVerticle {


    @Override
    public void start(Future<Void> startFuture) throws Exception {
        super.start(startFuture);


        vertx.deployVerticle(new ReceiverVerticle(), ar -> {
            if (ar.succeeded()) {
                vertx.deployVerticle(new SenderVerticle());
                vertx.deployVerticle(new RoutingHandler());
            } else {
                System.out.println("Deployment failed...");
            }
        });

    }
}
