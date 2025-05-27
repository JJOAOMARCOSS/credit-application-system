package com.bankjoaomarcos.credit.application.system.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
//@Table(name = "Cliente")
data class Customer(
    @Column(nullable = false)
    var firstName: String = "",

    @Column(nullable = false)
    var lastName: String = "",

    @Column(nullable = false, unique = true)
    var cpf: String = "",

    @Column(nullable = false, unique = true)
    var email: String = "",

    @Column(nullable = false)
    var income: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    var password: String = "",

    @Embedded
    var address: Address = Address(),

    @OneToMany(
        mappedBy = "customer",
        cascade = [CascadeType.REMOVE, CascadeType.PERSIST],
        fetch = FetchType.LAZY,
        orphanRemoval = true
    )
    var credits: MutableList<Credit> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)
