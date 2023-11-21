package web.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import web.app.domain.Product;
import web.app.dto.ProductRequest;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface ProductMapper {

    ProductRequest productToProductRequest(Product product);

//    @Mapping(source = "id", ignore = true)
    Product productRequestToProduct(ProductRequest productRequest);

    List<ProductRequest> productListToProductRequestList(List<Product> productList);


}
