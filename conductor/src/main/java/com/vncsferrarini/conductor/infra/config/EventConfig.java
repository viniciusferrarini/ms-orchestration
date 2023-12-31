package com.vncsferrarini.conductor.infra.config;

import com.vncsferrarini.conductor.infra.dto.CreatePaymentEvent;
import com.vncsferrarini.conductor.infra.dto.EventMessage;
import com.vncsferrarini.conductor.infra.events.EventProcessor;
import com.vncsferrarini.conductor.infra.events.EventType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class EventConfig {

    @Bean
    public Map<EventType, EventProcessor<EventMessage>> getEventProcessors(List<EventProcessor<EventMessage>> processors) {
        return processors.stream()
                .collect(toMap(EventProcessor::getEvent, Function.identity()));
    }

}
