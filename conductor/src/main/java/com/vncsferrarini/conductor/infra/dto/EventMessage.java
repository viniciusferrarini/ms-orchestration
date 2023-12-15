package com.vncsferrarini.conductor.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vncsferrarini.conductor.infra.events.EventProcessorType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Map;

import static com.vncsferrarini.conductor.infra.events.EventProcessorType.resolve;

@Builder
@RequiredArgsConstructor
public class EventMessage<T> implements Serializable {

    @JsonProperty("headers")
    private final Map<String, String> headers;

    @Getter
    @JsonProperty("data")
    private final T data;

    public EventProcessorType getEvent() {
        return resolve(this.headers.get("event"));
    }

}
