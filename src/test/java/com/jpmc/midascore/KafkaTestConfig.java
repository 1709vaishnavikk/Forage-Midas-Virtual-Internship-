package com.jpmc.midascore;

import com.jpmc.midascore.foundation.Transaction;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@TestConfiguration
public class KafkaTestConfig {

    @Bean
    public KafkaTemplate<String, Transaction> kafkaTemplate() {
        return Mockito.mock(KafkaTemplate.class);
    }
}
