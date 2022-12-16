package com.blacksooooo.kotlinjpa.storage.delivery

import com.blacksooooo.kotlinjpa.common.enum.DeliveryStatus
import com.blacksooooo.kotlinjpa.storage.BaseEntity
import com.blacksooooo.kotlinjpa.storage.address.AddressEntity
import javax.persistence.*

@Entity
@Table(name = "delivery")
class DeliveryEntity (
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    var status: DeliveryStatus,
    @Embedded
    val address: AddressEntity
) : BaseEntity() {
    val city: String
        get() = address.city
    val street: String
        get() = address.street
    val zipCode: String
        get() = address.zipCode
    constructor(city: String, street: String, zipCode: String): this(
        DeliveryStatus.READY, AddressEntity(city, street, zipCode)
    )
}