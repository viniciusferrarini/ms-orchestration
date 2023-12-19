package com.vncsferrarini.conductor.core.usecase;

import com.vncsferrarini.conductor.infra.dto.CreatePaymentEvent;
import com.vncsferrarini.conductor.infra.events.EventProcessor;
import com.vncsferrarini.conductor.infra.events.EventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreatePaymentUseCase implements EventProcessor<CreatePaymentEvent> {

    @Override
    public void process(final CreatePaymentEvent eventBody) {
        log.info(eventBody.toString());
    }

    @Override
    public EventType getEvent() {
        return EventType.CREATE_PAYMENT;
    }

}
