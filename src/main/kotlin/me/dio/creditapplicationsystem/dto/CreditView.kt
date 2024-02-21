package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.enumeration.Status
import me.dio.creditapplicationsystem.entity.Credit
import java.math.BigDecimal
import java.util.*

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallaments: Int,
    val status: Status,
    val emailCustomer: String?,
    val incomeCustomer: BigDecimal?
) {
    constructor(credit: Credit): this(
        creditCode = credit.code,
        creditValue = credit.value,
        numberOfInstallaments = credit.numberOfInstallaments,
        status = credit.status,
        emailCustomer = credit.customer?.email,
        incomeCustomer = credit.customer?.income


    )

}
