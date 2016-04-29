package sample.domain.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import sample.infrastructure.mapper.CustomerMapper

@Repository
open class CustomerRepository {

    @Autowired
    open lateinit var customerMapper: CustomerMapper

    fun selectAll() = customerMapper.selectAll()

    fun selectById(id: Int) = customerMapper.selectById(id)
}
