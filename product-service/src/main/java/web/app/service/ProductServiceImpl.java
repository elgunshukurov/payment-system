package web.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.app.repository.ProductRepository;
import web.app.domain.Product;
import web.app.dto.ProductRequest;
import web.app.mapper.ProductMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    @Transactional
    public void updateInventory(String productId) {
        Product product = productRepository
                .findById(Long.valueOf(productId))
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + productId));

        int stockCount = product.getStock();

        if (stockCount>=1) {
            product.setStock(stockCount-1);
        } else {
            throw new IllegalStateException("Product out of stock!");
        }
    }


    @Override
    public boolean isInStock(String productId) {
        Product product = productRepository
                .findById(Long.valueOf(productId))
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + productId));
        return product.getStock()>=1;
    }

    @Override
    public List<ProductRequest> getAllProducts() {
        return productMapper.productListToProductRequestList(productRepository.findAll());
    }

    @Override
    public void addProduct(ProductRequest productRequest) {
        System.out.println("Product Request : " + productRequest);
        Product product = productMapper.productRequestToProduct(productRequest);
        System.out.println("Product  : " + product);
        productRepository.save(product);
    }
}
