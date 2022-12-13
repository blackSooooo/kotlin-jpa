package com.blacksooooo.kotlinjpa.domain.item

import com.blacksooooo.kotlinjpa.storage.item.ItemEntity
import com.blacksooooo.kotlinjpa.storage.item.ItemRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ItemReader(
    private val itemRepository: ItemRepository
) {
    fun findAllItems(): List<ItemEntity> {
        return itemRepository.findAll()
    }

    fun findOneById(id: Long): ItemEntity {
        return itemRepository.findByIdOrNull(id)
            ?: throw RuntimeException()
    }
}