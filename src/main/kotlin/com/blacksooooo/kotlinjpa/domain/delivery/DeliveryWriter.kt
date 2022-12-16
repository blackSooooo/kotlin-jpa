package com.blacksooooo.kotlinjpa.domain.delivery

import com.blacksooooo.kotlinjpa.storage.delivery.DeliveryEntity
import com.blacksooooo.kotlinjpa.storage.delivery.DeliveryRepository
import org.springframework.stereotype.Component

@Component
class DeliveryWriter(
    private val deliveryRepository: DeliveryRepository
) {
    fun save(city: String, street: String, zipCode: String): Long {
        val delivery = deliveryRepository.save(
            DeliveryEntity(city, street, zipCode)
        )
        return delivery.id
    }
}