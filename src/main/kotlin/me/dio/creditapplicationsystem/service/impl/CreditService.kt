package me.dio.creditapplicationsystem.service.impl

import me.dio.creditapplicationsystem.entity.credit
import me.dio.creditapplicationsystem.exception.BusinessException
import me.dio.creditapplicationsystem.repository.CreditRepository
import me.dio.creditapplicationsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService

) : ICreditService {
    override fun save(credit: credit): credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerID: Long): List<credit> = this.creditRepository.findAllByCustomerId(customerID)

    override fun findByCreditCode(customerID: Long, creditCode: UUID): credit {
        val credit: credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinessException("CreditCode $creditCode not found"))
        return if (credit.customer?.id == customerID) credit else throw IllegalArgumentException("Contact admin")
    }
}