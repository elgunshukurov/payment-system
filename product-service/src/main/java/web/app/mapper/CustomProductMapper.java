package web.app.mapper;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import web.app.domain.Product;
import web.app.dto.ProductRequest;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class CustomProductMapper implements ProductMapper{


    @Override
    public ProductRequest productToProductRequest(Product product) {

        ProductRequest productRequest = new ProductRequest();
        productRequest.setId(String.valueOf(product.getId()));
        productRequest.setPrice(product.getPrice());
        productRequest.setProductName(product.getProductName());
        productRequest.setStock(product.getStock());

        return productRequest;
    }

    @Override
    public Product productRequestToProduct(ProductRequest productRequest) {

        Product product = new Product();
        product.setPrice(productRequest.getPrice());
        product.setProductName(productRequest.getProductName());
        product.setStock(productRequest.getStock());

        return product;
    }

    @Override
    public List<ProductRequest> productListToProductRequestList(List<Product> productList) {
        return productList
                .stream()
                .map(this::productToProductRequest).collect(Collectors.toList());
    }
}
