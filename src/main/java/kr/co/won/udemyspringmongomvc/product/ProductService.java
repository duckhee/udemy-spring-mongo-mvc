package kr.co.won.udemyspringmongomvc.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public String save(Product product) {
        // TODO use a DTO
        // TODO validate the objects
        return productRepository.save(product).getId();
    }

    public Product findById(String id) {
        return productRepository.findById(id)
                .orElse(null);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
