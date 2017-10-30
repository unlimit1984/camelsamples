package com.javapro.learn;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by Vladimir_Vysokomorny on 30-Oct-17.
 */
public class MainApp {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {

                    from("file:data/input?noop=true")
                            .to("file:data/output");

                }
            });
            context.start();
            Thread.sleep(5000);

        } finally {
            context.stop();
        }
    }
}
