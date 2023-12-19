package com.vncsferrarini.conductor.infra.events;

public interface EventProcessor<T>{

    void process(T eventBody);

    EventType getEvent();

}
