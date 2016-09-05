package de.predic8.camel;

import org.apache.camel.builder.RouteBuilder;

public class ConsumerRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        from("file:in")
                .id("file-in")
                .log("Nachricht: ${body}");


        from("activemq:in")
                .id("queue-in")
                .log("Nachricht verarbeitet: ${body}")
                .to("file:processed");


    }
}
