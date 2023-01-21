package com.example.s24260bank;

import com.example.s24260bank.models.Client;
import com.example.s24260bank.models.Transaction;
import com.example.s24260bank.storages.ClientStorage;
import com.example.s24260bank.storages.TransactionStorage;
import com.example.s24260bank.types.StatusType;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class TransactionServiceTest {
    @Mock
    ClientStorage clientStorage;

    @Mock
    TransactionStorage transactionStorage;

    @InjectMocks
    TransactionService transactionService;
    @Test
    void doTransaction() {
        //given
//        Client client = new Client(1, null, null, 0);
//        Transaction transaction = new Transaction(null, 0, 0, StatusType.ACCEPTED);
//        when(clientStorage.getClientById(anyInt())).thenReturn(client);
    }

    @Test
    void doDepositMoneyTransaction() {
    }
}