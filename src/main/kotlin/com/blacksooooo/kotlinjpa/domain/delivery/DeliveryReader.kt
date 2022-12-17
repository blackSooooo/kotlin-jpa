package com.blacksooooo.kotlinjpa.domain.delivery

import com.blacksooooo.kotlinjpa.storage.delivery.DeliveryEntity
import com.blacksooooo.kotlinjpa.storage.delivery.DeliveryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class DeliveryReader(
    private val deliveryRepository: DeliveryRepository
) {
    fun findOneById(id: Long): DeliveryEntity {
        return deliveryRepository.findByIdOrNull(id)
            ?: throw RuntimeException()
    }
}