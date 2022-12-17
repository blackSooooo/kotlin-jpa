package com.blacksooooo.kotlinjpa.domain.order

import com.blacksooooo.kotlinjpa.common.enum.OrderStatus

data class Order (
    val memberId: Long,
    val deliveryId: Long,
    val status: OrderStatus = OrderStatus.READY
)