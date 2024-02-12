package me.dio.creditapplicationsystem.service

import me.dio.creditapplicationsystem.entity.credit
import java.util.UUID

interface ICreditService {

    fun save(credit: credit): credit

    fun findAllByCustomer(customerID: Long): List<credit>

    fun findByCreditCode(customerID: Long, creditCode: UUID): credit
}