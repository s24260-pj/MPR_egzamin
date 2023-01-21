package com.example.s24260bank.storages;

import com.example.s24260bank.models.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientStorage {
    private List<Client> clientList;

    public ClientStorage() {
        this.clientList = new ArrayList<>();
        this.clientList.add(
                new Client(
                        1,
                        "Tomek",
                        "Saver",
                        1000.00
                )
        );
        this.clientList.add(
                new Client(
                        2,
                        "John",
                        "Doe",
                        1000.00
                )
        );
    }

    public Client getClientById(int id) {
        for (Client client : this.clientList) {
            if (client.getId().equals(id)) {
                return client;
            }
        }

        return null;
    }

    public Client addClient(Integer id, String firstName, String lastName, double balance) {
        Client client = new Client(id, firstName, lastName, balance);

        this.clientList.add(client);

        return client;
    }
}
