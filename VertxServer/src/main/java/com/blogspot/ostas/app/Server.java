package com.blogspot.ostas.app;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;


public class Server extends AbstractVerticle {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new Server(), stringAsyncResult -> {
            System.out.println("Deployment complete...");
        });
    }

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req -> {
            req.response().putHeader("Content-type", "text/html").end("<html><body><h1>Hello World!</h1></body></html>");
        }).listen(8080);
    }
}
