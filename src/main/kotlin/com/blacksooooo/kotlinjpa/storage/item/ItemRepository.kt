package com.blacksooooo.kotlinjpa.storage.item

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository: JpaRepository<ItemEntity, Long>