package com.vncsferrarini.conductor.infra.listener;

import com.vncsferrarini.conductor.infra.dto.EventMessage;
import com.vncsferrarini.conductor.infra.events.EventProcessor;
import com.vncsferrarini.conductor.infra.events.EventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
public class EventListener {

    private final Map<EventType, EventProcessor<EventMessage>> eventProcessors;

    public EventListener(final Map<EventType, EventProcessor<EventMessage>> eventProcessors) {
        this.eventProcessors = eventProcessors;
    }

    @RabbitListener(queues = "events_queue")
    public void listen(final EventMessage message) {
        log.info(message.toString());
        eventProcessors.get(message.getEvent()).process(message);
    }

}
