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
        return null;
    }

    public Product findById(String id) {
        return null;
    }

    public List<Product> findAll() {
        return List.of();
    }

    public void deleteById(String id) {

    }
}
