package me.dio.creditapplicationsystem.entity

import jakarta.persistence.*
import me.dio.creditapplicationsystem.enumeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "credito")
data class Credit(
    @Column(nullable = false, unique = true) var code : UUID = UUID.randomUUID(),
    @Column(nullable = false) val value : BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallament : LocalDate,
    @Column(nullable = false) val numberOfInstallaments : Int = 0,
    @Enumerated val status : Status = Status.IN_PROGRESS,
    @ManyToOne var customer : Customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id : Long? = null)
