package com.bankjoaomarcos.credit.application.system.dto

import com.bankjoaomarcos.credit.application.system.entity.Address
import com.bankjoaomarcos.credit.application.system.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Invalid Input") val firstName: String,
    @field:NotEmpty(message = "Invalid Input") val lastName: String,
    @field:NotEmpty(message = "Invalid Input")
    @CPF(message = "This invalid CPF") val cpf: String,
    @field:NotNull("Invalid input") val income: BigDecimal,
    @field:Email(message = "Invalid Input")
    @field:NotEmpty(message = "Invalid Input") val email: String,
    @field:NotEmpty(message = "Invalid Input") val password: String,
    @field:NotEmpty(message = "Invalid Input") val zipCode: String,
    @field:NotEmpty(message = "Invalid Input") val street: String
) {

    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}