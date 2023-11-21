package web.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import web.app.dto.request.ProductRequest;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8082")
public interface ProductServiceClient {

    @PutMapping("/api/products/{productId}/updateInventory")
    void updateProductInventory(@PathVariable("productId") String productId);

    @GetMapping("/api/products/{productId}/isInStock")
    boolean isProductInStock(@PathVariable("productId") String productId);

    @GetMapping("/api/products/all")
     ResponseEntity<List<ProductRequest>> getAllProducts();

}
