package org.pmor.springparambug.resource

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/items")
@RestController
class SimpleResource {


    @GetMapping
    fun getStuff(filter: FilterCriteria): List<String> {
        println(filter)
        return listOf(filter.nested?.code ?: "", filter.nested?.status ?: "")
    }
}

data class FilterCriteria(val type: String?, val nested: NestedFilter?)

data class NestedFilter(val code: String?, val status: String?)
