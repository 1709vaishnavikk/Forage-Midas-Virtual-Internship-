package com.jpmc.midascore;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createMidasTopic() {
        return new NewTopic("midas-transactions", 1, (short) 1);
    }
}
