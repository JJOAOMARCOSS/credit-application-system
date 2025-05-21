package com.bankjoaomarcos.credit.application.system.repository

import com.bankjoaomarcos.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository: JpaRepository<Credit, Long>