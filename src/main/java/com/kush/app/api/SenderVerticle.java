package com.kush.app.api;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class SenderVerticle extends AbstractVerticle {

    private static final String API_ADDRESS="api.resolver";
    private static final String MsgPayload="Sending bit data";

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        super.start(startFuture);
        Buffer MsgBuffer= Buffer.buffer(MsgPayload);

        vertx.eventBus().request(API_ADDRESS,MsgBuffer,ar->{
            if(ar.succeeded()){
                System.out.println("Message sent on eventBus, message received back ::"+ar.result().body());
            }
            else {
                System.out.println("Message sending failed::"+ar.cause());
            }
        });


    }
}
