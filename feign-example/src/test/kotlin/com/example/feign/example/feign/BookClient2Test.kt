package com.example.feign.example.feign

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.options
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

/*
Exemplo em Kotlin baseado no exemplo em Java dos links abaixo:
https://medium.com/swlh/spring-boot-how-to-unit-test-a-feign-client-in-isolation-using-only-service-name-4e0fc9e151a7
https://github.com/sumantrana/FeignClientExample
 */

@SpringBootTest(classes = [FeignConfig::class])
@TestInstance(Lifecycle.PER_CLASS)
class BookClient2Test{

    private lateinit var wireMockServer: WireMockServer

    @Autowired
    private lateinit var bookClient2: BookClient2

    @BeforeAll
    fun setup(){
        wireMockServer = WireMockServer(options().port(8081))
        wireMockServer.start()
    }

    @Test
    fun `should get a list of books from the service`(){

        val body = """[{"book":{"isbn":"1447264533","author":"Margaret Mitchell","title":"Gone with the Wind","synopsis":null,"language":null},"links":[{"rel":"self","href":"http://localhost:8081/api/books/1447264533"}]},{"book":{"isbn":"0151072558","author":"George Orwell","title":"Animal Farm","synopsis":null,"language":null},"links":[{"rel":"self","href":"http://localhost:8081/api/books/0151072558"}]},{"book":{"isbn":"0451524934","author":"George Orwell","title":"1984","synopsis":null,"language":null},"links":[{"rel":"self","href":"http://localhost:8081/api/books/0451524934"}]}]"""

        wireMockServer.stubFor( get ( urlPathMatching("/api/books"))
            .willReturn(aResponse().withStatus(200).withBody(body)
                .withHeader("Content-Type", "application/json")))

        val books = bookClient2.findAll(null)

        println(books)

        assertThat(books?.size, `is`(3))
    }
}

@EnableFeignClients(basePackages = ["com.example.feign.example"], clients = [BookClient2::class])
@Configuration
@EnableAutoConfiguration
class FeignConfig{
}

