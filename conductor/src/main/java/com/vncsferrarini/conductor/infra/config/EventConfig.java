package com.vncsferrarini.conductor.infra.config;

import com.vncsferrarini.conductor.infra.events.EventProcessor;
import com.vncsferrarini.conductor.infra.events.EventProcessorType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

@Configuration
public class EventConfig {

    @Bean
    public Map<EventProcessorType, EventProcessor> getEventProcessors(List<EventProcessor> processors) {
        return processors.stream()
                .collect(toMap(EventProcessor::getEvent, Function.identity()));
    }

}
