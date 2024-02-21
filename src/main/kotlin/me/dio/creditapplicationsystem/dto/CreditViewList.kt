package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.entity.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallaments: Int

) {
    constructor(credit: Credit): this(
        creditCode = credit.code,
        creditValue = credit.value,
        numberOfInstallaments = credit.numberOfInstallaments
    )

}
