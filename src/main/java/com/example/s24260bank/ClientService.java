package com.example.s24260bank;

import com.example.s24260bank.models.Client;
import com.example.s24260bank.storages.ClientStorage;
import org.springframework.stereotype.Component;

@Component
public class ClientService {
    ClientStorage clientStorage;

    public ClientService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }

    public Client getClientById(Integer id) {
        return this.clientStorage.getClientById(id);
    }

    public Client registerClient(Integer id, String firstName, String lastName, double balance) {
        if (this.getClientById(id) != null) {
            throw new RuntimeException("Klient istnieje w bazie danych");
        }

        return this.clientStorage.addClient(id, firstName, lastName, balance);
    }
}
