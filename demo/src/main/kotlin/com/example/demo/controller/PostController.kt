package com.example.demo.controller

import com.example.demo.http.client.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController(
        val postService: PostService
) {

    @GetMapping("posts")
    fun posts(){
        val posts = postService.getPosts()
        posts.forEach{
            println(it)
            println()
        }
    }

}