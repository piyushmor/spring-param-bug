package org.pmor.springparambug

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringParamBugApplication {
    @Bean
    fun kotlinModule() = KotlinModule()
}

fun main(args: Array<String>) {
    runApplication<SpringParamBugApplication>(*args)
}
