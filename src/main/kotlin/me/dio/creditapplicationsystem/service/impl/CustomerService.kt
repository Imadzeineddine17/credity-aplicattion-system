package me.dio.creditapplicationsystem.service.impl

import me.dio.creditapplicationsystem.entity.customer
import me.dio.creditapplicationsystem.exception.BusinessException
import me.dio.creditapplicationsystem.repository.CustomerRepository
import me.dio.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: customer): customer =
        this.customerRepository.save(customer)


    override fun findById(id: Long): customer =
        this.customerRepository.findById(id).orElseThrow {
            throw BusinessException ("Id $id not found")
        }


    override fun delete(id: Long) {
        val customer: customer = this.findById(id)
        this.customerRepository.delete(customer)
    }
}