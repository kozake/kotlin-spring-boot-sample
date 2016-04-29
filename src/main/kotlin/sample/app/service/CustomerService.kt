package sample.app.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import sample.domain.entity.Customer
import sample.domain.repository.CustomerRepository

@Service
open class CustomerService {

    @Autowired
    open lateinit var customerRepository: CustomerRepository

    @Transactional
    fun selectAll():List<Customer> {
        return customerRepository.selectAll()
    }

    @Transactional
    fun selectById(id: Int):Customer {
        return customerRepository.selectById(id)
    }
}
