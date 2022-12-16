package com.blacksooooo.kotlinjpa.storage.item

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "movie")
@DiscriminatorValue("M")
class MovieEntity(
    @Column(name = "director")
    val director: String,
    @Column(name = "actor")
    val actor: String,

    name: String,
    price: Long,
    stockQuantity: Int,
) : ItemEntity(name, price, stockQuantity)