package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.entity.credit
import java.math.BigDecimal
import java.util.UUID

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallaments: Int

) {
    constructor(credit: credit): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallaments = credit.numberOfInstallaments
    )

}
