package com.bankjoaomarcos.credit.application.system.service

import com.bankjoaomarcos.credit.application.system.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustomer(customerId: Long): List<Credit>
    fun findByCreditCore(customerId: Long, creditCode: UUID): Credit
}