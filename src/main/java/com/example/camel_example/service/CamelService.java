package com.example.camel_example.service;

import com.example.camel_example.utility.JsonValidation;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamelService {

    @Autowired
    private JsonValidation validation;

    public boolean SendToKafka(String order) {
        boolean valid = validation.validate(order);
        if (valid) {
            try (CamelContext context = new DefaultCamelContext()) {
                context.addRoutes(new RouteBuilder() {
                    public void configure() {
                        from("direct:start")
                                .routeId("toKafka")
                                .to("activemq:queue:orders")
                                .log("\n${body}");
                    }
                });

                context.start();

                ProducerTemplate producerTemplate = context.createProducerTemplate();
                producerTemplate.sendBody("direct:start", order);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return false;
    }
}
