package com.vncsferrarini.conductor.infra.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

//    @Bean
//    public EventMessageConverter eventMessageConverter() {
//        return new EventMessageConverter();
//    }

//    @Bean
//    public SimpleRabbitListenerContainerFactory myFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
//        var factory = new SimpleRabbitListenerContainerFactory();
//        configurer.configure(factory, connectionFactory);
//        factory.setMessageConverter(new EventMessageConverter());
//        return factory;
//    }

}
