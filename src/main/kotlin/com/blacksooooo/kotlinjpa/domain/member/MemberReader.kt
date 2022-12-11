package com.blacksooooo.kotlinjpa.domain.member

import com.blacksooooo.kotlinjpa.storage.member.MemberEntity
import com.blacksooooo.kotlinjpa.storage.member.MemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class MemberReader(
    private val memberRepository: MemberRepository
) {
    fun findAllMembers(): List<MemberEntity> {
        return memberRepository.findAll()
    }

    fun findOneById(id: Long): MemberEntity {
        return memberRepository.findByIdOrNull(id)
            ?: throw RuntimeException()
    }
}