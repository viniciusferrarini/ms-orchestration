package com.vncsferrarini.payment;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class CreatePaymentEvent {

    private final Map<String, Object> headers;

    private final String message;

}
