package me.dio.creditapplicationsystem.service

import me.dio.creditapplicationsystem.entity.Credit
import java.util.UUID

interface ICreditService {

    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerID: Long): List<Credit>

    fun findByCreditCode(customerID: Long, creditCode: UUID): Credit
}