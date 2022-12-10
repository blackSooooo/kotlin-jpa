package com.blacksooooo.kotlinjpa.domain.member

import com.blacksooooo.kotlinjpa.controller.v1.member.request.CreateMemberRequest
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberWriter: MemberWriter,
    private val memberValidator: MemberValidator
) {
    fun join(member: CreateMemberRequest): Long {
        memberValidator.validateDuplicateMemberByName(member.name)
        return memberWriter.save(toMember(member))
    }

    private fun toMember(member: CreateMemberRequest): Member {
        return Member(
            name = member.name,
            city = member.city,
            street = member.street,
            zipCode = member.zipCode
        )
    }
}