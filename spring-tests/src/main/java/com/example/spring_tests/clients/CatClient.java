package com.example.spring_tests.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CatClient {
    public String getCatFact() {
        // 1. Create the client
        RestClient restClient = RestClient.create();

        // 2. Fetch data and convert to String
        String response = restClient.get()
                .uri("https://catfact.ninja/fact")
                .retrieve()
                .body(String.class);

        // 3. Print the result
        System.out.println("⬇️ RECEIVED DATA ⬇️");
        System.out.println(response);

        return response;
    }
}
