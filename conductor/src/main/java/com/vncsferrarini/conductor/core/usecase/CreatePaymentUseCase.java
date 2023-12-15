package com.vncsferrarini.conductor.core.usecase;

import com.vncsferrarini.conductor.infra.dto.CreatePaymentEvent;
import com.vncsferrarini.conductor.infra.dto.EventMessage;
import com.vncsferrarini.conductor.infra.events.EventProcessor;
import com.vncsferrarini.conductor.infra.events.EventProcessorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreatePaymentUseCase implements EventProcessor {

    @Override
    public <T extends EventMessage<T>> void process(final T eventBody) {
        log.info("CREATE_PAYMENT_EVENT");
        var event = (CreatePaymentEvent) eventBody;
        log.info(event.toString());
    }

    @Override
    public EventProcessorType getEvent() {
        return EventProcessorType.CREATE_PAYMENT;
    }

}
