package com.vncsferrarini.conductor.infra.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class CreatePaymentEvent extends EventMessage {

    final String message;

    public CreatePaymentEvent(final Map<String, Object> headers, final String message) {
        super(headers);
        this.message = message;
    }

    CreatePaymentEvent(final Map<String, Object> headers) {
        super(headers);
        this.message = null;
    }
}