package com.blacksooooo.kotlinjpa.domain.item

import com.blacksooooo.kotlinjpa.storage.item.ItemEntity
import com.blacksooooo.kotlinjpa.storage.item.ItemRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class ItemWriterTest: BehaviorSpec ({
    val repository = mockk<ItemRepository>()
    val sut = ItemWriter(repository)

    Given("item 도메인 객체가 주어졌을 때") {
        val item = Item("name", 0, 0)

        every { repository.save(any()) } returns ItemEntity("name", 0, 0)

        When("save를 하게 되면") {
            sut.save(item)

            Then("엔티티가 저장된다.") {
                verify(exactly = 1) {
                    repository.save(any())
                }
            }
        }
    }
})