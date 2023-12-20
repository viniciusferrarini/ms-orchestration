package com.vncsferrarini.payment.infra;

import com.vncsferrarini.payment.CreatePaymentEvent;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.cloud.stream.function.StreamBridge;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class PaymentProducer {


    private final AmqpAdmin amqpAdmin;
    private final AmqpTemplate amqpTemplate;
    private final StreamBridge streamBridge;

    @PostConstruct
    public void sendMessage() {
        final CreatePaymentEvent createPaymentEvent = new CreatePaymentEvent(Map.of("event", "CREATE_PAYMENT"), "teste");
        //amqpTemplate.send("events-queue", new Message(Bytes.toBytes(createPaymentEvent)));
        log.info("Sending message");
        //streamBridge.send( "events-queue", createPaymentEvent);
    }

}
