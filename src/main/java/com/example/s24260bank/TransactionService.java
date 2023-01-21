package com.example.s24260bank;

import com.example.s24260bank.models.Client;
import com.example.s24260bank.models.Transaction;
import com.example.s24260bank.storages.ClientStorage;
import com.example.s24260bank.storages.TransactionStorage;
import com.example.s24260bank.types.StatusType;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TransactionService {
    private TransactionStorage transactionStorage;
    private ClientStorage clientStorage;

    public TransactionService(ClientStorage clientStorage, TransactionStorage transactionStorage) {
        this.transactionStorage = transactionStorage;
        this.clientStorage = clientStorage;
    }

    public Transaction doTransaction(int id, double transactionAmount) {
        Client client = this.clientStorage.getClientById(id);

        if (client == null) {
            throw new RuntimeException("Nie posiadamy tego uzytkownika w bazie");
        }

        double clientBalance = client.getBalance() - transactionAmount;

        if (clientBalance > 0) {
            client.setBalance(clientBalance);

            Transaction transaction = new Transaction(client, transactionAmount, clientBalance, StatusType.ACCEPTED);
            this.transactionStorage.addClientTransaction(transaction);

            return transaction;
        }

        return new Transaction(client, transactionAmount, clientBalance, StatusType.DECLINED);
    }

    public Transaction doDepositMoneyTransaction(int id, double transactionAmount) {
        Client client = this.clientStorage.getClientById(id);

        if (client == null) {
            throw new RuntimeException("Nie posiadamy tego uzytkownika w bazie");
        }

        double clientBalance = client.getBalance() + transactionAmount;

        if (clientBalance > 0) {
            client.setBalance(clientBalance);

            Transaction transaction = new Transaction(client, transactionAmount, clientBalance, StatusType.ACCEPTED);
            this.transactionStorage.addClientTransaction(transaction);

            return transaction;
        }

        return new Transaction(client, transactionAmount, clientBalance, StatusType.DECLINED);
    }
}
