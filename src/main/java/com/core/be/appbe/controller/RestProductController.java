package com.core.be.appbe.controller;

import com.core.be.appbe.common.model.RestResponse;
import com.core.be.appbe.common.util.Constants;
import com.core.be.appbe.model.request.ProductRequest;
import com.core.be.appbe.service.product.DeleteProductService;
import com.core.be.appbe.service.product.PostNewProductService;
import com.core.be.appbe.service.product.PutUpdateProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/product")
public class RestProductController {

    private PostNewProductService postNewProductService;
    private PutUpdateProductService putUpdateProductService;
    private DeleteProductService deleteProductService;

    public RestProductController(PostNewProductService postNewProductService,
                                 PutUpdateProductService putUpdateProductService,
                                 DeleteProductService deleteProductService){

        this.postNewProductService = postNewProductService;
        this.putUpdateProductService = putUpdateProductService;
        this.deleteProductService = deleteProductService;
    }

    @PostMapping(value = "/new-product")
    public ResponseEntity<RestResponse> newProduct(@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok()
                .body(RestResponse.builder()
                        .data(postNewProductService.execute(productRequest))
                        .message(Constants.MSG_SUCCESS)
                        .status(Constants.CODE_SUCCESS)
                        .build());
    }

    @PutMapping(value = "/update-product/{id}")
    public ResponseEntity<RestResponse> updateProduct(@PathVariable("id")Long id,
                                                      @RequestBody ProductRequest productRequest){
        productRequest.setId(id);
        return ResponseEntity.ok()
                .body(RestResponse.builder()
                        .status(Constants.CODE_SUCCESS)
                        .message(Constants.MSG_SUCCESS)
                        .data(putUpdateProductService.execute(productRequest))
                        .build());
    }

    @DeleteMapping(value = "/delete-product/{id}")
    public ResponseEntity<RestResponse> deleteProduct(@PathVariable("id")Long id){
        ProductRequest productRequest = new ProductRequest();
        productRequest.setId(id);
        return ResponseEntity.ok(RestResponse.builder()
                .status(Constants.CODE_SUCCESS)
                .data(deleteProductService.execute(productRequest))
                .build());
    }
}
