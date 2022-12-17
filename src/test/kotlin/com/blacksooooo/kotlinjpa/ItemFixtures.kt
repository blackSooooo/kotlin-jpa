package com.blacksooooo.kotlinjpa

import com.blacksooooo.kotlinjpa.storage.item.ItemEntity

fun createItem(
    name: String,
    price: Long,
    stockQuantity: Int
): ItemEntity {
    return ItemEntity(name, price, stockQuantity)
}