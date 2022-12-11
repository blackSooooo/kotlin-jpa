package com.blacksooooo.kotlinjpa.domain.member

import org.springframework.stereotype.Component

@Component
class MemberValidator(
    private val memberReader: MemberReader
) {
    fun validateDuplicateMemberByName(name: String) {
        val findAllMembers = memberReader.findAllMembers()
        if(findAllMembers.isNotEmpty()) {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
    }
}