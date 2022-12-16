package com.blacksooooo.kotlinjpa.domain.order

import com.blacksooooo.kotlinjpa.common.enum.OrderStatus
import com.blacksooooo.kotlinjpa.domain.delivery.DeliveryWriter
import com.blacksooooo.kotlinjpa.domain.item.ItemReader
import com.blacksooooo.kotlinjpa.domain.member.MemberReader
import com.blacksooooo.kotlinjpa.storage.item.ItemEntity
import com.blacksooooo.kotlinjpa.storage.member.MemberEntity
import com.blacksooooo.kotlinjpa.support.exception.NotDeliveryCanceledException

class OrderService(
    private val memberReader: MemberReader,
    private val itemReader: ItemReader,
    private val deliveryWriter: DeliveryWriter,
    private val orderWriter: OrderWriter,
    private val orderItemWriter: OrderItemWriter,
    private val orderReader: OrderReader,
    private val orderItemReader: OrderItemReader
) {
    fun createOrder(memberId: Long, itemId: Long, count: Int) {
        val member = memberReader.findOneById(memberId)
        val item = itemReader.findOneById(itemId)
        createDeliveryAndOrderAndOrderItem(member, item, count)
        item.removeStock(count)
    }

    fun cancelOrder(orderId: Long) {
        val order = orderReader.findOneById(orderId)
        orderStatusValidate(order.status)
        order.cancelOrder()
        addItemsStockByOrderId(order.id)
    }

    private fun createDeliveryAndOrderAndOrderItem(member: MemberEntity, item: ItemEntity, count: Int) {
        val deliveryId = deliveryWriter.save(member.city, member.street, member.zipCode)
        val orderId = orderWriter.save(member.id, deliveryId)
        orderItemWriter.save(item.id, orderId, item.price, count)
    }

    private fun orderStatusValidate(status: OrderStatus) {
        if (status == OrderStatus.CANCELED) throw NotDeliveryCanceledException()
    }

    private fun addItemsStockByOrderId(orderId: Long) {
        orderItemReader.findAllByOrderId(orderId).forEach {
            itemReader.findOneById(it.itemId).also { item ->
                item.addStock(it.count)
            }
        }
    }
}