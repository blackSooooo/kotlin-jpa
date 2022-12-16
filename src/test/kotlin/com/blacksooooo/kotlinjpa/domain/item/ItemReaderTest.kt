package com.blacksooooo.kotlinjpa.domain.item

import com.blacksooooo.kotlinjpa.storage.item.ItemEntity
import com.blacksooooo.kotlinjpa.storage.item.ItemRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.springframework.data.repository.findByIdOrNull

class ItemReaderTest: BehaviorSpec ({
    val repository = mockk<ItemRepository>()
    val sut = ItemReader(repository)

    Given("올바른 id가 주어진 경우") {
        val item = ItemEntity("name", 0, 0)

        every { repository.findByIdOrNull(any()) } returns item

        When("해당 id로 조회하면") {
            val actual = sut.findOneById(0L)

            Then("item을 조회할 수 있다.") {
                actual shouldBe item
            }
        }
    }

    Given("올바르지 않은 id가 주어진 경우") {

        every { repository.findByIdOrNull(any()) } throws RuntimeException()

        When("해당 id로 조회하면") {
            Then("예외가 발생한다.") {
                shouldThrow<RuntimeException> {
                    sut.findOneById(-1L)
                }
            }
        }
    }
})