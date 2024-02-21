package me.dio.creditapplicationsystem.repository

import me.dio.creditapplicationsystem.entity.Address
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Month

@ActiveProfiles("test")
@EnableJpaRepositories(basePackages = ["me.dio.creditapplicationsystem"])
@DataJpaTest
class CreditRepositoryTest {
    @Autowired
    lateinit var creditRepository: CreditRepository

    @Autowired
    lateinit var em: TestEntityManager

    @Test
    fun `should find credit by credit code`(){
        //given
        val customer = em.persist(buildCustomer())
        val credit1 = em.persist(buildCredit(customer = customer))
        val credit2 = em.persist(buildCredit(customer = customer))

        //when
        val fakeCredit1 = creditRepository.findByCreditCode(credit1.code)
        val fakeCredit2 = creditRepository.findByCreditCode(credit2.code)

        //then
        Assertions.assertThat(fakeCredit1).isNotNull
        Assertions.assertThat(fakeCredit2).isNotNull
        Assertions.assertThat(fakeCredit1).isSameAs(credit1)
        Assertions.assertThat(fakeCredit2).isSameAs(credit2)
    }

    @Test
    fun `should find all credits by customer id`(){
        //given
        val customer = em.persist(buildCustomer())
        val credit1 = em.persist(buildCredit(customer = customer))
        val credit2 = em.persist(buildCredit(customer = customer))

        //when
        val creditList: List<Credit> = creditRepository.findAllByCustomerId(customer.id!!)

        //then
        Assertions.assertThat(creditList).isNotEmpty
        Assertions.assertThat(creditList.size).isEqualTo(2)
        Assertions.assertThat(creditList).contains(credit1, credit2)

    }

    private fun buildCredit(
        crediValue: BigDecimal = BigDecimal.valueOf(500.0),
        dayFirstInstallment: LocalDate = LocalDate.of(2023, Month.APRIL, 22),
        numberOfInstallaments: Int = 5,
        customer: Customer
    ): Credit = Credit(
        value = crediValue,
        dayFirstInstallament = dayFirstInstallment,
        numberOfInstallaments = numberOfInstallaments,
        customer = customer
    )

    private fun buildCustomer(
        firstName: String = "Cami",
        lastName: String = "Cavalcante",
        cpf: String = "04243355656",
        income: BigDecimal = BigDecimal.valueOf(1000.0),
        email: String = "cami@gmail.com",
        zipCode: String = "04245875",
        street: String = "rua da cami",
    ) = Customer(
        firstName = firstName,
        lastName = lastName,
        cpf = cpf,
        email = email,
        address = Address(
            zipCode = zipCode,
            street = street
        ),
        income = income,
    )
}