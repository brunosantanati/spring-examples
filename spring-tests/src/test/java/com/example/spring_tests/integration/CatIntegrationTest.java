package com.example.spring_tests.integration;

import com.example.spring_tests.SpringTestsApplication;
import com.example.spring_tests.clients.CatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@SpringBootTest(classes = {SpringTestsApplication.class})
public class CatIntegrationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CatClient catClient;

    @Test
    public void testGetFact() {
        String catFact = catClient.getCatFact();
        AssertJUnit.assertNotNull(catFact);
        AssertJUnit.assertTrue(catFact.matches(".+fact.+length.+"));
    }
}
