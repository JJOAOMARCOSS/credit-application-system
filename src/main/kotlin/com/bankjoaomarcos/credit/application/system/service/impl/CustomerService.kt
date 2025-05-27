package com.bankjoaomarcos.credit.application.system.service.impl

import com.bankjoaomarcos.credit.application.system.entity.Customer
import com.bankjoaomarcos.credit.application.system.repository.CustomerRepository
import com.bankjoaomarcos.credit.application.system.service.ICustomerService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)


    override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow{
            throw RuntimeException("Id $id not found")
        }

    override fun delete(id: Long) = this.customerRepository.deleteById(id)

    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(ex: RuntimeException): Map<String, String> {
        return mapOf("error" to ex.message.orEmpty())
    }
}