package com.example.s24260bank;

import com.example.s24260bank.models.Client;
import com.example.s24260bank.models.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S24260BankApplication {
	ClientService clientService;
	TransactionService transactionService;

	public static void main(String[] args) {
		SpringApplication.run(S24260BankApplication.class, args);
	}

	public S24260BankApplication(ClientService clientService, TransactionService transactionService) {
		this.clientService = clientService;
		this.transactionService = transactionService;

		Client registeredClient = this.clientService.registerClient(3, "Steve", "Working", 30.00);
		Transaction transactionRegisteredUser = transactionService.doTransaction(registeredClient.getId(), 200.00);

		System.out.println(transactionRegisteredUser);

		Client client = this.clientService.getClientById(1);

		Transaction transaction = transactionService.doTransaction(client.getId(), 200.00);

		System.out.println(transaction.getActualClientBalance());

		Transaction transaction1 = transactionService.doDepositMoneyTransaction(client.getId(), 400.00);

		System.out.println(transaction1.getActualClientBalance());

		System.out.println(client);
	}
}
