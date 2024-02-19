package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto (
    @field: NotEmpty val firstName: String,
    @field: NotEmpty val lastName: String,
    @field: NotNull(message = "Dados Incorretos") val income: BigDecimal,
    @field: NotEmpty val zipCode: String,
    @field: NotEmpty val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode
        return customer


    }
}
