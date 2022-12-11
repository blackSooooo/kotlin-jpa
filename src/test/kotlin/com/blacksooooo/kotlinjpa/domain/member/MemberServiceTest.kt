package com.blacksooooo.kotlinjpa.domain.member

import com.blacksooooo.kotlinjpa.controller.v1.member.request.CreateMemberRequest
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk

class MemberServiceTest : BehaviorSpec({
    val memberWriter = mockk<MemberWriter>()
    val memberValidator = mockk<MemberValidator>()
    val sut = MemberService(memberWriter, memberValidator)

    Given("member dto가 주어진 경우") {
        val member = Member("name", "city", "street", "zipCode")
        val memberRequest = CreateMemberRequest("name", "city", "street", "zipCode")

        every { memberValidator.validateDuplicateMemberByName(any()) } throws IllegalStateException()
        every { memberWriter.save(member) }

        When("name 중복이 있으면") {
            Then("예외가 발생한다.") {
                shouldThrow<IllegalStateException> {
                    sut.join(memberRequest)
                }
            }
        }
    }
})
