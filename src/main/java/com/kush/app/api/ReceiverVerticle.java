package com.kush.app.api;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;


public class ReceiverVerticle extends AbstractVerticle {
  //Address and payload for the eventbus
    private String API_ADDRESS="api.resolver";
    private String MsgRply="Event handled successfully, sending back message";

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        super.start(startFuture);


        vertx.eventBus().consumer(API_ADDRESS).handler(ar->{
            System.out.println("Message received from eventbus :: "+ar.body());
            ar.reply(MsgRply);
        });

    }
}
