package com.blacksooooo.kotlinjpa.controller.v1.member

import com.blacksooooo.kotlinjpa.controller.v1.member.request.CreateMemberRequest
import com.blacksooooo.kotlinjpa.domain.member.MemberService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/member")
class MemberController(
    private val memberService: MemberService
) {

    @PostMapping(
        value = ["/"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createMember(@RequestBody body: CreateMemberRequest) {
        memberService.join(body)
    }
}