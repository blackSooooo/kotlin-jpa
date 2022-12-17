package com.blacksooooo.kotlinjpa

import com.blacksooooo.kotlinjpa.storage.order.OrderItemEntity

fun createOrderItem(
    itemId: Long,
    orderId: Long,
    price: Long,
    count: Int
): OrderItemEntity {
    return OrderItemEntity(itemId, orderId, price, count)
}