package com.blacksooooo.kotlinjpa.controller.v1.member.request

data class CreateMemberRequest(
    val name: String,
    val city: String,
    val street: String,
    val zipCode: String
)
