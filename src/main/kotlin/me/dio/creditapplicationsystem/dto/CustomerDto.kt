package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Address
import me.dio.creditapplicationsystem.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field: NotEmpty(message = "Dados Incorretos") val firstName: String,
    @field: NotEmpty(message = "Dados Incorretos") val lastName: String,
    @field: NotEmpty(message = "Dados Incorretos")
    @field: CPF(message = "CPF invalido!") val cpf: String,
    @field: NotNull(message = "Dados Incorretos") val income: BigDecimal,
    @field: Email(message = "Email Incorretos") val email: String,
    @field: NotEmpty(message = "Dados Incorretos") val password: String,
    @field: NotEmpty(message = "Dados Incorretos") val zipCode: String,
    @field: NotEmpty(message = "Dados Incorretos") val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        email = this.email,
        income = this.income,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
