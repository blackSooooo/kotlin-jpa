package com.blacksooooo.kotlinjpa.domain.item

import com.blacksooooo.kotlinjpa.storage.item.ItemEntity

data class Item (
    val name: String,
    val price: Long,
    val stockQuantity: Int
) {
    constructor(entity: ItemEntity): this(
        name = entity.name,
        price = entity.price,
        stockQuantity = entity.stockQuantity
    )
}