package com.blacksooooo.kotlinjpa.storage.address

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class AddressEntity (
    @Column(name = "city")
    val city: String,
    @Column(name = "street")
    val street: String,
    @Column(name = "zip_code")
    val zipCode: String
)