package com.blacksooooo.kotlinjpa.domain.order

import com.blacksooooo.kotlinjpa.*
import com.blacksooooo.kotlinjpa.common.enum.DeliveryStatus
import com.blacksooooo.kotlinjpa.common.enum.OrderStatus
import com.blacksooooo.kotlinjpa.domain.delivery.DeliveryReader
import com.blacksooooo.kotlinjpa.domain.delivery.DeliveryWriter
import com.blacksooooo.kotlinjpa.domain.item.ItemReader
import com.blacksooooo.kotlinjpa.domain.member.MemberReader
import com.blacksooooo.kotlinjpa.support.exception.NotDeliveryCanceledException
import com.blacksooooo.kotlinjpa.support.exception.NotEnoughStockException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class OrderServiceTest: BehaviorSpec ({
    val memberReader = mockk<MemberReader>()
    val itemReader = mockk<ItemReader>()
    val deliveryWriter = mockk<DeliveryWriter>()
    val deliveryReader = mockk<DeliveryReader>()
    val orderWriter = mockk<OrderWriter>()
    val orderReader = mockk<OrderReader>()
    val orderItemWriter = mockk<OrderItemWriter>()
    val orderItemReader = mockk<OrderItemReader>()
    val sut = OrderService(
        memberReader, itemReader, deliveryWriter, deliveryReader,
        orderWriter, orderItemWriter, orderReader, orderItemReader
    )

    Given("아이템의 재고가 충분하지 않을 때") {
        val count = 10
        val member = createMember()
        val item = createItem("item", 100, 5)
        val delivery = createDelivery(member.city, member.street, member.zipCode)
        val order = createOrder(member.id, delivery.id)
        val orderItem = createOrderItem(item.id, order.id, item.price, count)

        every { memberReader.findOneById(any()) } returns member
        every { itemReader.findOneById(any()) } returns item
        every { deliveryWriter.save(any(), any(), any()) } returns delivery.id
        every { orderWriter.save(any(), any()) } returns order.id
        every { orderItemWriter.save(any(), any(), any(), any()) } returns orderItem.id

        When("주문을 생성하면") {
            Then("예외가 발생한다.") {
                shouldThrow<NotEnoughStockException> {
                    sut.createOrder(0, 0, count)
                }
            }
        }
    }

    Given("멤버, 아이템 정보, 수량이 주어졌을 때") {
        val count = 10
        val member = createMember()
        val item = createItem("item", 100, 15)
        val delivery = createDelivery(member.city, member.street, member.zipCode)
        val order = createOrder(member.id, delivery.id)
        val orderItem = createOrderItem(item.id, order.id, item.price, count)

        every { memberReader.findOneById(any()) } returns member
        every { itemReader.findOneById(any()) } returns item
        every { deliveryWriter.save(any(), any(), any()) } returns delivery.id
        every { orderWriter.save(any(), any()) } returns order.id
        every { orderItemWriter.save(any(), any(), any(), any()) } returns orderItem.id

        When("주문을 하면") {
            sut.createOrder(0, 0, count)
            Then("주문이 생성된다.") {
                item.stockQuantity shouldBe 5
            }
        }
    }

    Given("배송 상태가 COMP일 때") {
        val order = createOrder(0, 0)
        val delivery = createDelivery("city", "street", "zipCode").apply { this.status = DeliveryStatus.COMP }

        every { orderReader.findOneById(any()) } returns order
        every { deliveryReader.findOneById(any()) } returns delivery

        When("주문을 취소하면") {
            Then("예외가 발생한다.") {
                shouldThrow<NotDeliveryCanceledException> {
                    sut.cancelOrder(0)
                }
            }
        }
    }

    Given("특정한 orderId가 주어졌을 때") {
        val order = createOrder(0, 0)
        val delivery = createDelivery("city", "street", "zipCode")
        val orderItem1 = createOrderItem(1, 0, 10, 10)
        val orderItem2 = createOrderItem(2, 0, 10, 10)
        val item = createItem("item", 10, 10)

        every { orderReader.findOneById(any()) } returns order
        every { deliveryReader.findOneById(any()) } returns delivery
        every { orderItemReader.findAllByOrderId(any()) } returns listOf(orderItem1, orderItem2)
        every { itemReader.findOneById(any()) } returns item

        When("주문을 취소하면") {
            sut.cancelOrder(0)
            Then("주문이 취소된다.") {
                order.status shouldBe OrderStatus.CANCELED
                item.stockQuantity shouldBe 30
            }
        }
    }

})