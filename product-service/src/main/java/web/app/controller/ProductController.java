package web.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.app.dto.ProductRequest;
import web.app.service.ProductService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductRequest productRequest) {
        productService.addProduct(productRequest);
    }

    @PutMapping("/{productId}/updateInventory")
    public ResponseEntity<String> updateProductInventory(@PathVariable("productId") String productId) {
        productService.updateInventory(productId);
        return ResponseEntity.ok("Product inventory updated for productId: " + productId);
    }

    @GetMapping("/{productId}/isInStock")
    public ResponseEntity<Boolean> isProductInStock(@PathVariable("productId") String productId) {
        boolean isInStock = productService.isInStock(productId);
        return ResponseEntity.ok(isInStock);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductRequest>> getAllProducts() {
        List<ProductRequest> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

}
