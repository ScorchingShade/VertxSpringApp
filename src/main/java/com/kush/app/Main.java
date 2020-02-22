package com.kush.app;

import com.kush.app.api.ReceiverVerticle;
import com.kush.app.api.SenderVerticle;
import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;


@SpringBootApplication
@ComponentScan
@Slf4j
public class Main {


    private Vertx vertx;

    Main(){
        this.vertx=Vertx.vertx();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    /**
     * Deploying new verticles through a helper class
     */
    @PostConstruct
    public void deployServerVerticles() {
      vertx.deployVerticle(new DeployerVerticle(), ar->{
          if(ar.succeeded()){
              log.debug("Successfully deployed verticle.");
          }
          else{
              log.debug("Deployment failed ::"+ar.cause());
          }
      });
    }
}
