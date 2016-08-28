package de.predic8.camel;

import org.apache.camel.builder.RouteBuilder;

public class ConsumerRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        from("activemq:in")
                .id("queue-in")
                .log("Nachricht empfangen: ${body}")
                .to("activemq:bereit");

        from("activemq:bereit")
                .log("Nachricht verarbeitet: ${body}")
                .to("file:processed");

    }
}
