package org.pmor.springparambug

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTest(@Autowired val restTemplate: TestRestTemplate) {
    @LocalServerPort
    private val port = 0

    @Test
    @Throws(Exception::class)
    fun `nested filter should be consumed properly`() {
        Assertions.assertThat(
            restTemplate!!.getForObject("http://localhost:$port/items?nested.code=a",
                String::class.java)).contains("\"a\"")
    }
}
