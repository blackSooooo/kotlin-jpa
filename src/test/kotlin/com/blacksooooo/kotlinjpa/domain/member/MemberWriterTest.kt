package com.blacksooooo.kotlinjpa.domain.member

import com.blacksooooo.kotlinjpa.storage.member.MemberEntity
import com.blacksooooo.kotlinjpa.storage.member.MemberRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class MemberWriterTest : BehaviorSpec({
    val repository = mockk<MemberRepository>()
    val sut = MemberWriter(repository)

    Given("member 도메인 객체가 주어졌을 때") {
        val member = Member("name", "city", "street", "zipCode")
        val memberEntity = MemberEntity("name", "city", "street", "zipCode")

        every { repository.save(any()) } returns memberEntity

        When("save를 하게 되면") {
            val actual = sut.save(member)

            Then("엔티티가 저장된다.") {
                actual shouldBe 0L
            }
        }
    }

})
