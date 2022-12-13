package com.blacksooooo.kotlinjpa.domain.item

import com.blacksooooo.kotlinjpa.storage.item.ItemEntity
import com.blacksooooo.kotlinjpa.storage.item.ItemRepository
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class ItemWriter(
    private val itemRepository: ItemRepository
) {
    @Transactional
    fun save(item: Item) {
        itemRepository.save(
            ItemEntity(
                name = item.name,
                price = item.price,
                stockQuantity = item.stockQuantity
            )
        )
    }
}