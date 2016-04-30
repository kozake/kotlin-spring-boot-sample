package sample.app.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.context.WebApplicationContext
import sample.domain.entity.Customer
import sample.domain.repository.CustomerRepository
import java.util.concurrent.atomic.AtomicLong

@Service
@Scope(value= WebApplicationContext.SCOPE_REQUEST,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
open class CustomerService {

    open val logger: Logger = LoggerFactory.getLogger(CustomerService::class.java)

    open val counter = AtomicLong()

    @Autowired
    open lateinit var customerRepository: CustomerRepository

    @Transactional
    fun selectAll():List<Customer> {

        logger.debug("debug::${counter.incrementAndGet()}")
        return customerRepository.selectAll()
    }

    @Transactional
    fun selectById(id: Int):Customer {
        return customerRepository.selectById(id)
    }
}
