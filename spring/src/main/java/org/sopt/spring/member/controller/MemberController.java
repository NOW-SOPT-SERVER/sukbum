package org.sopt.spring.member.controller;


import lombok.RequiredArgsConstructor;
import org.sopt.spring.common.auth.PrincipalHandler;
import org.sopt.spring.member.service.MemberService;
import org.sopt.spring.member.dto.MemberCreateDto;
import org.sopt.spring.member.dto.MemberFindDto;
import org.sopt.spring.member.service.dto.UserJoinResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;
    private final PrincipalHandler principalHandler;

    @PostMapping
    public ResponseEntity<UserJoinResponse> createMember(
            @RequestBody MemberCreateDto memberCreateDto
    ) {
        UserJoinResponse userJoinResponse = memberService.createMember(memberCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userJoinResponse.userId())
                .body(
                        userJoinResponse
                );
    }

    @PostMapping("/refresh")
    public ResponseEntity<UserJoinResponse> refreshToken(){
        UserJoinResponse userJoinResponse = memberService.refreshToken(
                principalHandler.getUserIdFromPrincipal()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userJoinResponse.userId())
                .body(
                        userJoinResponse
                );
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMemberById(
            @PathVariable Long memberId
    ){
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<MemberFindDto>> findAllMembers() {
        List<MemberFindDto> members = memberService.findAllMembers();
        return ResponseEntity.ok(members);
    }
}
