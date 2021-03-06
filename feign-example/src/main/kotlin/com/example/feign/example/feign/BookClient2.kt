package com.example.feign.example.feign

import com.example.feign.example.domain.BookResource
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(url="\${book.service.url}", name="bookClient")
interface BookClient2 {

    @GetMapping
    fun findAll(@RequestParam(required = false) titleParam: String?): List<BookResource?>?

}