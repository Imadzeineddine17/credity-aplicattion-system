package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field: NotNull(message = "Dados Incorretos") val creditValue: BigDecimal,
    @field: Future val dayFirstOfInstallament: LocalDate,
    val numberOfInstallaments: Int,
    @field: NotNull(message = "Dados Incorretos") val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallament = this.dayFirstOfInstallament,
        numberOfInstallaments = this.numberOfInstallaments,
        customer = Customer(id = this.customerId)
    )
}
