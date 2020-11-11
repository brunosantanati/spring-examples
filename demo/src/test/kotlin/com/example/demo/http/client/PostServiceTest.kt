package com.example.demo.http.client

import com.example.demo.utils.FileUtils
import com.google.gson.Gson
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import io.mockk.clearAllMocks
import io.mockk.junit5.MockKExtension
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.net.HttpURLConnection

@ExtendWith(MockKExtension::class)
class PostServiceTest {

    private val mockWebServer = MockWebServer()

    @AnnotationSpec.BeforeEach
    fun setUp() = clearAllMocks()

    @BeforeEach
    fun start() {
        mockWebServer.start(port = 9999)
    }

    @AfterEach
    fun stop() = mockWebServer.shutdown()

    @Test
    fun `should get a list of posts when calling the PostService`() {

        val response200 = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(FileUtils.readTestResourceFile("posts/status-200.json"))

        mockWebServer.enqueue(response200)

        val actualResult = PostService(
            gson = Gson(),
            url = "http://localhost:9999"
        ).getPosts()

        actualResult.size shouldBe 100
        actualResult.get(0).id shouldBe 1
        actualResult.get(0).userId shouldBe 1
        actualResult.get(0).title shouldBe "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
        actualResult.get(0).body shouldStartWith "quia et suscipit"
    }
}