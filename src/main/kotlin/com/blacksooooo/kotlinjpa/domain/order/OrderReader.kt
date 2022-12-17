package com.blacksooooo.kotlinjpa.domain.order

import com.blacksooooo.kotlinjpa.storage.order.OrderEntity
import com.blacksooooo.kotlinjpa.storage.order.OrderRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class OrderReader(
    private val orderRepository: OrderRepository
) {
    fun findAll(): List<OrderEntity> {
        return orderRepository.findAll()
    }

    fun findOneById(id: Long): OrderEntity {
        return orderRepository.findByIdOrNull(id)
            ?: throw RuntimeException()
    }
}