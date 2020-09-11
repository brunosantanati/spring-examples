package com.example.feign.example

import com.example.feign.example.feign.BookClient
import feign.Feign
import feign.slf4j.Slf4jLogger
import feign.Logger
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import feign.okhttp.OkHttpClient

class BookControllerFeignClientBuilder {
    val bookClient = createClient(BookClient::class.java, "http://localhost:8081/api/books")

    private fun <T> createClient(type: Class<T>, uri: String): T {
        return Feign.builder()
                .client(OkHttpClient())
                .encoder(GsonEncoder())
                .decoder(GsonDecoder())
                .logger(Slf4jLogger(type))
                .logLevel(Logger.Level.FULL)
                .target(type, uri)
    }
}