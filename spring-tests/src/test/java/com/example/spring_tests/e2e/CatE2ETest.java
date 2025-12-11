package com.example.spring_tests.e2e;

import com.example.spring_tests.SpringTestsApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestClient;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@SpringBootTest(
        classes = {SpringTestsApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT // 1. Start real server
)
public class CatE2ETest extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    private int port; // 2. Get the random port

    @Test
    public void testGetFactE2E() {
        // 3. Act: Hit YOUR application from the "outside"
        // We use a simple generic client here, or TestRestTemplate
        RestClient testClient = RestClient.create("http://localhost:" + port);

        String response = testClient.get()
                .uri("/get-fact") // Hitting YOUR endpoint
                .retrieve()
                .body(String.class);

        // 4. Assert
        AssertJUnit.assertNotNull(response);
        AssertJUnit.assertTrue(response.matches(".+fact.+length.+"));
    }
}
