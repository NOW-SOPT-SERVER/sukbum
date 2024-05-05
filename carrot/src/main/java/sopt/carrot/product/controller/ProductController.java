package sopt.carrot.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.carrot.common.SuccessMessage;
import sopt.carrot.common.SuccessStatusResponse;
import sopt.carrot.product.dto.ProductCreateDto;
import sopt.carrot.product.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product/{memberId}")
    public ResponseEntity<SuccessStatusResponse> createProduct(
            @PathVariable Long memberId,
            @RequestBody ProductCreateDto productCreateDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", productService.create(memberId, productCreateDto))
                .body(SuccessStatusResponse.of(SuccessMessage.PRODUCT_CREATE_SUCCESS));
    }
}
