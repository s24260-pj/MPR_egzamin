package com.example.s24260bank.models;

import com.example.s24260bank.types.StatusType;

public class Transaction {
    private final double actualClientBalance;
    private Client client;
    private double balance;
    private StatusType statusType;

    public Transaction(Client client, double balance, double actualClientBalance, StatusType statusType) {
        this.client = client;
        this.balance = balance;
        this.statusType = statusType;
        this.actualClientBalance = actualClientBalance;
    }

    public Client getClient() {
        return this.client;
    }

    public double getActualClientBalance() {
        return this.actualClientBalance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "actualClientBalance=" + actualClientBalance +
                ", client=" + client +
                ", balance=" + balance +
                ", statusType=" + statusType +
                '}';
    }
}
