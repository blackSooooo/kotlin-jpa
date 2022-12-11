package com.blacksooooo.kotlinjpa.domain.member

import com.blacksooooo.kotlinjpa.storage.member.MemberEntity
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk

class MemberValidatorTest : BehaviorSpec({
    val memberReader = mockk<MemberReader>()
    val sut = MemberValidator(memberReader)

    Given("이미 존재하는 회원 이름이 주어졌을 때") {
        val duplicatedName = "name"
        val existedMember = MemberEntity("name", "city", "street", "zipCode")

        every { memberReader.findAllMembers() } returns listOf(existedMember)

        When("member 검증을 하게 되면") {
            Then("예외가 발생한다.") {
                shouldThrow<IllegalStateException> {
                    sut.validateDuplicateMemberByName(duplicatedName)
                }
            }
        }
    }
})
