package sopt.carrot.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.carrot.common.SuccessMessage;
import sopt.carrot.common.SuccessStatusResponse;
import sopt.carrot.member.dto.MemberCreateDto;
import sopt.carrot.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<SuccessStatusResponse> createMember(
            @RequestBody MemberCreateDto memberCreateDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", memberService.create(memberCreateDto))
                .body(SuccessStatusResponse.of(SuccessMessage.MEMBER_CREATE_SUCCESS));
    }
}
