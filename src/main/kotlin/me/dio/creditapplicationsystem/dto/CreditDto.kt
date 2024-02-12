package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.credit
import me.dio.creditapplicationsystem.entity.customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field: NotNull(message = "Dados Incorretos") val creditValue: BigDecimal,
    @field: Future val dayFirstOfInstallament: LocalDate,
    val numberOfInstallaments: Int,
    @field: NotNull(message = "Dados Incorretos") val customerId: Long
) {
    fun toEntity(): credit = credit(
        creditValue = this.creditValue,
        dayFirstInstallament = this.dayFirstOfInstallament,
        numberOfInstallaments = this.numberOfInstallaments,
        customer = customer(id = this.customerId)
    )
}
