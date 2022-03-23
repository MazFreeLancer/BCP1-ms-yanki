package com.nttdata.bcp1.msyanki.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic yankiTopic() {
        return TopicBuilder.name("yankiPay").build();
    }
}
