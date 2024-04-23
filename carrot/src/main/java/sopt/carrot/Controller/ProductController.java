package sopt.carrot.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.carrot.Common.Dto.SuccessMessage;
import sopt.carrot.Common.SuccessStatusResponse;
import sopt.carrot.Domain.Dto.ProductCreateDto;
import sopt.carrot.Service.ProductService;

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
