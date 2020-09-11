package com.example.feign.example.feign

import com.example.feign.example.domain.Book
import com.example.feign.example.domain.BookResource
import feign.Headers
import feign.Param
import feign.RequestLine


interface BookClient {
    @RequestLine("GET /{isbn}")
    fun findByIsbn(@Param("isbn") isbn: String?): BookResource?

    @RequestLine("GET")
    fun findAll(): List<BookResource?>?

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    fun create(book: Book?)
}