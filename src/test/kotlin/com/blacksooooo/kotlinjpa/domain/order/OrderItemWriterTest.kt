package com.blacksooooo.kotlinjpa.domain.order

import com.blacksooooo.kotlinjpa.createOrderItem
import com.blacksooooo.kotlinjpa.storage.order.OrderItemRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class OrderItemWriterTest: BehaviorSpec ({
    val repository = mockk<OrderItemRepository>()
    val sut = OrderItemWriter(repository)

    Given("orderItem 정보가 주어졌을 때") {
        val orderItem = createOrderItem(0, 0,0,0)

        every { repository.save(any()) } returns orderItem

        When("save를 하게 되면") {
            val actual = sut.save(0, 0, 0, 0)

            Then("엔티티가 저장된다.") {
                actual shouldBe 0L
            }
        }
    }
})