package com.vncsferrarini.conductor.infra.dto;

import com.vncsferrarini.conductor.infra.events.EventType;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import static com.vncsferrarini.conductor.infra.events.EventType.resolve;

@Builder
@RequiredArgsConstructor
public class EventMessage {

    private final Map<String, Object> headers;

    public final EventType getEvent() {
        return resolve(headers.get("event").toString());
    }

}
