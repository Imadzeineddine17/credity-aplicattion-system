package me.dio.creditapplicationsystem.repository

import me.dio.creditapplicationsystem.entity.credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository: JpaRepository<credit, Long>{

    fun findByCreditCode(creditCode: UUID): credit?
    @Query(value = "SELECT * FROM credito WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<credit>

}