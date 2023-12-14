package com.vncsferrarini.conductor.infra.events;

public interface EventProcessor {

    void process();

    EventProcessorType getEvent();

}
