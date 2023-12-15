package com.vncsferrarini.conductor.infra.listener;

import com.vncsferrarini.conductor.infra.dto.EventMessage;
import com.vncsferrarini.conductor.infra.events.EventProcessor;
import com.vncsferrarini.conductor.infra.events.EventProcessorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class EventListener {

    private final Map<EventProcessorType, EventProcessor> eventProcessors;

    public EventListener(final Map<EventProcessorType, EventProcessor> eventProcessors) {
        this.eventProcessors = eventProcessors;
    }

    @RabbitListener(queues = "events_queue")
    public <T extends EventMessage<T>> void listen(final EventMessage<T> message) {
        log.info(message.toString());
        eventProcessors.get(message.getEvent()).process(message.getData());
    }

}
