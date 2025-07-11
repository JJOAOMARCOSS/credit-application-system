package com.bankjoaomarcos.credit.application.system.dto

import com.bankjoaomarcos.credit.application.system.entity.Address
import com.bankjoaomarcos.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerDto(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String
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