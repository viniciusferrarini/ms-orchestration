package com.vncsferrarini.conductor.infra.events;

import com.vncsferrarini.conductor.infra.dto.EventMessage;

public interface EventProcessor {

    <T extends EventMessage<T>> void process(T eventBody);

    EventProcessorType getEvent();

}
