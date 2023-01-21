package com.example.s24260bank;

import com.example.s24260bank.models.Client;
import com.example.s24260bank.storages.ClientStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceUnitTest {
    @Mock
    ClientStorage clientStorage;

    @InjectMocks
    ClientService clientService;

    @Test
    void shouldReturnSameClientById() {
        //given
        Client client = new Client(1, null, null, 0);
        when(clientStorage.getClientById(anyInt())).thenReturn(client);

        //when
        Client client1 = clientService.getClientById(client.getId());

        //then
        assertThat(client1.getId()).isEqualTo(client.getId());
    }

    @Test
    void shouldReturnUserWhenRegistering() {
        //given
        Client client = new Client(1, null, null, 0);
        when(clientStorage.getClientById(anyInt())).thenReturn(null);
        when(clientStorage.addClient(anyInt(), any(), any(), anyDouble())).thenReturn(client);

        //when
        Client client1 = clientService.registerClient(1, null, null, 0);

        //then
        assertThat(client1).isEqualTo(client);
    }
}