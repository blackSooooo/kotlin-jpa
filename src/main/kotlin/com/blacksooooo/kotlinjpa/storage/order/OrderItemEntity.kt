package com.blacksooooo.kotlinjpa.storage.order

import com.blacksooooo.kotlinjpa.storage.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "order_item")
class OrderItemEntity(
    @Column(name = "ref_item_id")
    val itemId: Long,
    @Column(name = "ref_order_id")
    val orderId: Long,
    @Column(name = "price")
    val price: Long,
    @Column(name = "count")
    val count: Int,
) : BaseEntity() {
}