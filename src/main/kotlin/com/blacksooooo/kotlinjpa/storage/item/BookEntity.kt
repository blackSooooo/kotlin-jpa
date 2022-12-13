package com.blacksooooo.kotlinjpa.storage.item

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "book")
@DiscriminatorValue("B")
class BookEntity (
    @Column(name = "author")
    val author: String,
    @Column(name = "isbn")
    val isbn: String,

    name: String,
    price: Long,
    stockQuantity: Int,
) : ItemEntity(name, price, stockQuantity)