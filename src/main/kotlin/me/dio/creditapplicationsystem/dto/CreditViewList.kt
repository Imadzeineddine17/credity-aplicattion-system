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
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallaments = credit.numberOfInstallaments
    )

}
