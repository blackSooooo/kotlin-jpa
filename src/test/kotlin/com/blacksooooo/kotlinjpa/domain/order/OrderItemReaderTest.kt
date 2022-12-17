package com.blacksooooo.kotlinjpa.domain.order

import com.blacksooooo.kotlinjpa.createOrderItem
import com.blacksooooo.kotlinjpa.storage.order.OrderItemRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.mockk.every
import io.mockk.mockk

class  OrderItemReaderTest: BehaviorSpec ({
    val repository = mockk<OrderItemRepository>()
    val sut = OrderItemReader(repository)

    Given("특정 orderId가 주어졌을 때") {
        val orderItem1 = createOrderItem(1L, 1L, 100, 10)
        val orderItem2 = createOrderItem(2L, 2L, 200, 20)

        every { repository.findAllByOrderId(any()) } returns listOf(orderItem1, orderItem2)

        When("해당 id로 조회를 하면") {
            val actual = sut.findAllByOrderId(0)

            Then("orderItem 리스트를 조회할 수 있다.") {
                actual shouldHaveSize  2
            }
        }
    }
})