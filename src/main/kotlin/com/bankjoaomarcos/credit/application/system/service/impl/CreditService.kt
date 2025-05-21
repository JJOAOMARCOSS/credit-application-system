package com.bankjoaomarcos.credit.application.system.service.impl

import com.bankjoaomarcos.credit.application.system.entity.Credit
import com.bankjoaomarcos.credit.application.system.repository.CreditRepository
import com.bankjoaomarcos.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCore(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Creditcode $creditCode not found"))
        return if(credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }
}