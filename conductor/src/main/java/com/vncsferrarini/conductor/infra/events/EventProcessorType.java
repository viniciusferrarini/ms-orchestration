package com.vncsferrarini.conductor.infra.events;

import lombok.RequiredArgsConstructor;

import static java.util.Arrays.stream;

@RequiredArgsConstructor
public enum EventProcessorType {

    CREATE_PAYMENT,
    NAO_SEI;

    public static EventProcessorType resolve(final String event) {
        return stream(values())
                .filter(e -> e.name().equals(event))
                .findFirst()
                .orElseThrow();
    }

}