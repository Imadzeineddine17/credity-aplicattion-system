package me.dio.creditapplicationsystem.repository

import me.dio.creditapplicationsystem.entity.customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<customer, Long>