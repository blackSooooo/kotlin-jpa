package com.blacksooooo.kotlinjpa.domain.order

import com.blacksooooo.kotlinjpa.storage.order.OrderEntity
import com.blacksooooo.kotlinjpa.storage.order.OrderRepository
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class OrderWriter(
    private val orderRepository: OrderRepository
) {
    @Transactional
    fun save(memberId: Long, deliveryId: Long): Long {
        val order = orderRepository.save(
            OrderEntity(
                memberId = memberId,
                deliveryId = deliveryId
            )
        )
        return order.id
    }
}