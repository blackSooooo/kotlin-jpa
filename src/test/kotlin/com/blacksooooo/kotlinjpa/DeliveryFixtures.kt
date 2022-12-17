package com.blacksooooo.kotlinjpa

import com.blacksooooo.kotlinjpa.storage.delivery.DeliveryEntity

fun createDelivery(
    city: String,
    street: String,
    zipCode: String
): DeliveryEntity {
    return DeliveryEntity(city, street, zipCode)
}