package com.vncsferrarini.conductor.infra.listener;

import com.vncsferrarini.conductor.infra.events.EventProcessor;
import com.vncsferrarini.conductor.infra.events.EventProcessorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.vncsferrarini.conductor.infra.events.EventProcessorType.resolve;

@Slf4j
@Component
public class EventListener {

    private final Map<EventProcessorType, EventProcessor> eventProcessors;

    public EventListener(final Map<EventProcessorType, EventProcessor> eventProcessors) {
        this.eventProcessors = eventProcessors;
    }

    @RabbitListener(queues = "events_queue")
    public void listen(final Message message) {
        log.info(message.toString());
        eventProcessors.get(resolve(message.getMessageProperties().getHeader("event"))).process();
    }

}
