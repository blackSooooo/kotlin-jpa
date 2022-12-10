package com.blacksooooo.kotlinjpa.storage.member

import com.blacksooooo.kotlinjpa.storage.BaseEntity
import com.blacksooooo.kotlinjpa.storage.address.AddressEntity
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "member")
class MemberEntity(
    @Column(name = "name")
    val name: String,
    @Embedded
    val address: AddressEntity
) : BaseEntity() {
    val city: String
        get() = address.city
    val street: String
        get() = address.street
    val zipCode: String
        get() = address.zipCode

    constructor(
        name: String,
        city: String,
        street: String,
        zipCode: String
    ): this (
        name, AddressEntity(city, street, zipCode)
    )
}
