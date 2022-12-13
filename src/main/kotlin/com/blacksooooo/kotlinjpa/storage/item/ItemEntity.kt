package com.blacksooooo.kotlinjpa.storage.item

import com.blacksooooo.kotlinjpa.storage.BaseEntity
import com.blacksooooo.kotlinjpa.support.exception.NotEnoughStockException
import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "item")
@DiscriminatorColumn(name = "d_type")
class ItemEntity (
    @Column(name = "name")
    val name: String,
    @Column(name = "price")
    val price: Long,
    @Column(name = "stock_quantity")
    var stockQuantity: Int,
): BaseEntity() {
    fun addStock(quantity: Int) {
        this.stockQuantity += quantity
    }

    fun removeStock(quantity: Int) {
        val restStock = this.stockQuantity - quantity
        if (restStock < 0) {
            throw NotEnoughStockException()
        }
        this.stockQuantity = restStock
    }
}