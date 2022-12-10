package com.blacksooooo.kotlinjpa.domain.member

import com.blacksooooo.kotlinjpa.storage.member.MemberEntity
import com.blacksooooo.kotlinjpa.storage.member.MemberRepository
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class MemberWriter(
    private val memberRepository: MemberRepository,
    private val memberValidator: MemberValidator
) {
    @Transactional
    fun save(member: Member): Long {
        memberValidator.validateDuplicateMemberByName(member.name)
        val savedMember = memberRepository.save(
            MemberEntity(
                name = member.name,
                city = member.city,
                street = member.street,
                zipCode = member.zipCode
            )
        )
        return savedMember.id
    }
}