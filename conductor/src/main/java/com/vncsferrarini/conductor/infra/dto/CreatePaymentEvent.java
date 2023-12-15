package com.vncsferrarini.conductor.infra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;

public class CreatePaymentEvent extends EventMessage<CreatePaymentEvent> {

    @Getter
    @JsonProperty("message")
    private final String message;

    public CreatePaymentEvent(final Map<String, String> headers, final CreatePaymentEvent data, final String message) {
        super(headers, data);
        this.message = message;
    }

}