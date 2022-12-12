package com.blacksooooo.kotlinjpa.storage.delivery

import com.blacksooooo.kotlinjpa.common.enum.DeliveryStatus
import com.blacksooooo.kotlinjpa.storage.BaseEntity
import com.blacksooooo.kotlinjpa.storage.address.AddressEntity
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "delivery")
class DeliveryEntity (
    @Column(name = "status")
    val status: DeliveryStatus,
    @Embedded
    val address: AddressEntity
) : BaseEntity()