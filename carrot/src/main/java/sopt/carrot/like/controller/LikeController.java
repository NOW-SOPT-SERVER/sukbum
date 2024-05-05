package sopt.carrot.like.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.carrot.common.success.SuccessMessage;
import sopt.carrot.common.success.SuccessStatusResponse;
import sopt.carrot.like.service.LikeService;
import sopt.carrot.member.dto.MemberCreateDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/like")
    public ResponseEntity<SuccessStatusResponse> createMember(
            @RequestHeader Long memberId,
            @RequestHeader Long productId
    ){
        likeService.create(memberId, productId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessStatusResponse.of(SuccessMessage.LIKE_CREATE_SUCCESS));
    }
}
