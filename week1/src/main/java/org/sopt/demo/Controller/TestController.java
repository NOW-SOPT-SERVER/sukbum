package org.sopt.demo.Controller;

import org.sopt.demo.Controller.Dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "sopt 1차 세미나 테스트 api입니다.";
    }
    @GetMapping("/test/json")
    public ApiResponse testJson(){
        return ApiResponse.create("1차 세미나 json 리턴입니다");
    }
}
