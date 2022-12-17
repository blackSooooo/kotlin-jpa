package com.blacksooooo.kotlinjpa

import com.blacksooooo.kotlinjpa.storage.order.OrderEntity

fun createOrder(
    memberId: Long,
    deliveryId: Long
): OrderEntity {
    return OrderEntity(memberId, deliveryId)
}