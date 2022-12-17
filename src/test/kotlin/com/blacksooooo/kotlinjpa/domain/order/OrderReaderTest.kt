package com.blacksooooo.kotlinjpa.domain.order

import com.blacksooooo.kotlinjpa.storage.order.OrderRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk
import org.springframework.data.repository.findByIdOrNull

class OrderReaderTest: BehaviorSpec ({
    val repository = mockk<OrderRepository>()
    val sut = OrderReader(repository)

    Given("잘못된 id가 주어진 경우") {

        every { repository.findByIdOrNull(any()) } throws RuntimeException()

        When("조회를 하게 되면") {
            Then("예외가 발생한다.") {
                shouldThrow<RuntimeException> { sut.findOneById(0) }
            }
        }
    }
})