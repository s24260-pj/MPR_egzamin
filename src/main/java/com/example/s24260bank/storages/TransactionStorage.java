package com.example.s24260bank.storages;

import com.example.s24260bank.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TransactionStorage {
    private List<Transaction> transactionList;

    public TransactionStorage() {
        this.transactionList = new ArrayList<>();
    }

    public void addClientTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }
}
