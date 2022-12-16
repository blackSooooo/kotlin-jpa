package com.blacksooooo.kotlinjpa.domain.item

import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemReader: ItemReader,
    private val itemWriter: ItemWriter
) {
    fun saveItem(item: Item) {
        itemWriter.save(item)
    }

    fun findItems(): List<Item> {
        return itemReader.findAllItems().map { Item(it) }
    }

    fun findOneById(id: Long): Item {
        return Item(itemReader.findOneById(id))
    }
}