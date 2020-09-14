package com.example.feign.example.feign

import com.example.feign.example.domain.BookResource
import feign.RequestLine
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(url="\${book.service.url}", name="bookClient")
interface BookClient2 {

    @GetMapping
    fun findAll(): List<BookResource?>?

}