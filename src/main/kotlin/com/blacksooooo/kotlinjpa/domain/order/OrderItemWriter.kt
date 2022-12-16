package com.blacksooooo.kotlinjpa.domain.order

import com.blacksooooo.kotlinjpa.storage.order.OrderItemEntity
import com.blacksooooo.kotlinjpa.storage.order.OrderItemRepository
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class OrderItemWriter(
    private val orderItemRepository: OrderItemRepository
) {
    @Transactional
    fun save(itemId: Long, orderId: Long, price: Long, count: Int): Long {
        val orderItem = orderItemRepository.save(
            OrderItemEntity(
                itemId, orderId, price, count
            )
        )
        return orderItem.id
    }
}