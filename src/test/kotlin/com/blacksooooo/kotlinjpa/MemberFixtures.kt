package com.blacksooooo.kotlinjpa

import com.blacksooooo.kotlinjpa.storage.member.MemberEntity

const val MEMBER_NAME = "test_name"
const val CITY = "test_city"
const val STREET = "test_street"
const val ZIP_CODE = "test_zipCode"

fun createMember(
    name: String = MEMBER_NAME,
    city: String = CITY,
    street: String = STREET,
    zipCode: String = ZIP_CODE
): MemberEntity {
    return MemberEntity(name, city, street, zipCode)
}