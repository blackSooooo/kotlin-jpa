package com.blacksooooo.kotlinjpa.domain.member

import com.blacksooooo.kotlinjpa.storage.member.MemberEntity
import com.blacksooooo.kotlinjpa.storage.member.MemberRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.springframework.data.repository.findByIdOrNull

class MemberReaderTest : BehaviorSpec({
    val repository = mockk<MemberRepository>()
    val sut = MemberReader(repository)

    Given("memberId가 주어진 경우") {
        val memberId = 0L
        val member = MemberEntity("name", "city", "street", "zipCode")

        every { repository.findByIdOrNull(memberId) } returns member

        When("해당 id로 조회를 하면") {
            val actual = sut.findOneById(memberId)

            Then("member를 조회할 수 있다.") {
                actual shouldBe member
            }
        }
    }

    Given("잘못된 memberId가 주어진 경우") {
        val memberId = -1L

        every { repository.findByIdOrNull(memberId) } throws RuntimeException()

        When("해당 id로 조회를 하면") {
            Then("예외가 발생한다.") {
                shouldThrow<RuntimeException> {
                    sut.findOneById(memberId)
                }
            }
        }
    }
})
