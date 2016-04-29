package sample.infrastructure.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import sample.domain.entity.Customer

@Mapper
interface CustomerMapper {

    @Select("SELECT * FROM customer")
    fun selectAll(): List<Customer>

    @Select("SELECT * FROM customer where id = #{id}")
    fun selectById(id: Int): Customer
}
