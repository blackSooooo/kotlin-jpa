package com.blacksooooo.kotlinjpa.domain.order

import com.blacksooooo.kotlinjpa.createOrder
import com.blacksooooo.kotlinjpa.storage.order.OrderRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class OrderWriterTest: BehaviorSpec ({
    val repository = mockk<OrderRepository>()
    val sut = OrderWriter(repository)

    Given("order 정보가 주어졌을 때") {
        val order = createOrder(0, 0)

        every { repository.save(any()) } returns order

        When("save를 하게 되면") {
            val actual = sut.save(0, 0)

            Then("엔티티가 저장된다.") {
                actual shouldBe 0
            }
        }
    }
})