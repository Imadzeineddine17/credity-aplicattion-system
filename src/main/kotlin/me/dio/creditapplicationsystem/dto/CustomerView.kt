package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.entity.customer
import java.math.BigDecimal

data class CustomerView (
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String

) {
    constructor(customer: customer): this (
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipCode = customer.address.zipCode,
        street = customer.address.street
    )

}
