package sample.web.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sample.app.dto.Customers
import sample.app.service.CustomerService
import sample.domain.entity.Customer

@RestController
@RequestMapping("/customers")
open class CustomerController {

    @Autowired
    open lateinit var customerService: CustomerService

    @RequestMapping
    fun all(): Customers {

        return Customers(customerService.selectAll())
    }

    @RequestMapping(value = "{id}")
    fun greeting(@PathVariable id: Int): Customer {

        return customerService.selectById(id)
    }
}
