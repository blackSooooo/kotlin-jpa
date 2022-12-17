package com.blacksooooo.kotlinjpa.storage.order

import com.blacksooooo.kotlinjpa.common.enum.OrderStatus
import com.blacksooooo.kotlinjpa.storage.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "orders")
class OrderEntity(
    @Column(name = "ref_member_id")
    val memberId: Long,
    @Column(name = "ref_delivery_id")
    val deliveryId: Long,
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    var status: OrderStatus = OrderStatus.READY,
): BaseEntity() {
    fun cancelOrder() {
        this.status = OrderStatus.CANCELED
    }
}