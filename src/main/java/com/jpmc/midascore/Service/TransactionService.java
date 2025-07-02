package com.jpmc.midascore.Service;

import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.TransactionRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void processTransaction(Transaction tx, float incentiveAmount) {
        UserRecord sender = userRepository.findById(tx.getSenderId()).orElse(null);
        UserRecord recipient = userRepository.findById(tx.getRecipientId()).orElse(null);

        if (sender == null || recipient == null) return;

        if (sender.getBalance() < tx.getAmount()) return;

        // Update balances
        sender.setBalance(sender.getBalance() - tx.getAmount());
        recipient.setBalance(recipient.getBalance() + tx.getAmount() + incentiveAmount);

        // Save changes
        userRepository.save(sender);
        userRepository.save(recipient);

        // Save transaction with incentive
        transactionRepository.save(new TransactionRecord(sender, recipient, tx.getAmount(), incentiveAmount));
    }
}
