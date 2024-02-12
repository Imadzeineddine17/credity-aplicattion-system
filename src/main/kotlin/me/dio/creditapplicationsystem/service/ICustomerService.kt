package me.dio.creditapplicationsystem.service

import me.dio.creditapplicationsystem.entity.customer

interface ICustomerService {

    fun save(customer: customer): customer

    fun findById(id: Long): customer

    fun delete(id: Long)
}