package me.dio.creditapplicationsystem.entity

import jakarta.persistence.*
import me.dio.creditapplicationsystem.ennumeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "credito")
data class credit(
    @Column(nullable = false, unique = true) val creditCode : UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue : BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallament : LocalDate,
    @Column(nullable = false) val numberOfInstallaments : Int = 0,
    @Enumerated val status : Status = Status.IN_PROGRESS,
    @ManyToOne var customer : customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id : Long? = null)
