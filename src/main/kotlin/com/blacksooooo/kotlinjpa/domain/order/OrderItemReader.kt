package com.blacksooooo.kotlinjpa.domain.order

import com.blacksooooo.kotlinjpa.storage.order.OrderItemEntity
import com.blacksooooo.kotlinjpa.storage.order.OrderItemRepository
import org.springframework.stereotype.Component

@Component
class OrderItemReader(
    private val orderItemRepository: OrderItemRepository
) {
    fun findAllByOrderId(orderId: Long): List<OrderItemEntity> {
        return orderItemRepository.findAllByOrderId(orderId)
    }
}