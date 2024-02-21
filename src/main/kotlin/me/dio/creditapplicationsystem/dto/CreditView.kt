package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.enumeration.Status
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
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallaments = credit.numberOfInstallaments,
        status = credit.status,
        emailCustomer = credit.customer?.email,
        incomeCustomer = credit.customer?.income


    )

}
