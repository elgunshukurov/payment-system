package web.app.service;

import web.app.dto.ProductRequest;

import java.util.List;

public interface ProductService {


    void updateInventory(String productId);

    boolean isInStock(String productId);

    List<ProductRequest> getAllProducts();

    void addProduct(ProductRequest productRequest);
}
