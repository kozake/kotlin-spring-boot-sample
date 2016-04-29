package sample.web.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import sample.app.dto.Greeting
import java.util.concurrent.atomic.AtomicLong

@RestController
open class GreetingController {

    val counter = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {

        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }
}
