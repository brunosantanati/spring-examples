package com.example.demo.http.client

import com.example.demo.dto.PostDTO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service

@Service
class PostService(
        private val gson: Gson,
        @Value("\${jsonplaceholderUrl}") private val url: String
){

    fun getPosts(): List<PostDTO>{

        khttp.get(
                url = url,
                headers = HttpHeaders().also {
                    it.contentType = MediaType.APPLICATION_JSON
                }.toSingleValueMap()
        ).let { response ->
            println("response ${response.text}")
            val postsType = object : TypeToken<List<PostDTO>>() {}.type
            return gson.fromJson<List<PostDTO>>(response.text, postsType)
        }
    }

}