package ivan.zver.kur.service;


import ivan.zver.kur.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void addProduct(Product product);

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Optional<Product> putProductById(Long id, Product updatedProduct);

    void deleteProductById(Long id);

}
