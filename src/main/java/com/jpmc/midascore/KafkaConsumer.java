package com.jpmc.midascore;

import com.jpmc.midascore.Service.TransactionService;
import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Incentive;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.TransactionRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KafkaConsumer {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private RestTemplate restTemplate;

    @KafkaListener(topics = "midas-transactions", groupId = "midas-core-group")
    public void listen(Transaction transaction) {
        // Fetch incentive
        Incentive incentive = restTemplate.postForObject(
                "http://localhost:8080/incentive", transaction, Incentive.class);

        float incentiveAmount = (incentive != null) ? incentive.getAmount() : 0;

        // Pass to service
        transactionService.processTransaction(transaction, incentiveAmount);
    }
}
