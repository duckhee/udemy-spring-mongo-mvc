package kr.co.won.udemyspringmongomvc.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryMethodService {

    private final ProductRepository repository;

    public List<Product> searchByName(String name) {
        return repository.findAllByNameIgnoreCase(name);
    }

    public List<Product> searchByNameStartingWith(String name) {
        return repository.findAllByNameStartingWith(name);
    }

    public List<Product> searchByNameEndingWith(String name) {
        return repository.findAllByNameEndingWith(name);
    }

    public List<Product> searchByNameContaining(String name) {
        return repository.findAllByNameContainingIgnoreCase(name);
    }

    public List<Product> searchByPriceLittle(BigDecimal price) {
        return repository.findAllByPriceLessThan(price);
    }

    public List<Product> searchByPriceGreaterThan(BigDecimal price) {
        return repository.findAllByPriceGreaterThan(price);
    }

    public List<Product> searchByPriceBetween(BigDecimal min, BigDecimal max) {
        return repository.findAllByPriceBetween(min, max);
    }

    public List<Product> sortAndSortASCField(String productName) {
        return repository.findAllByNameContainingIgnoreCaseOrderByPriceDesc(productName);
    }

    public List<Product> sortByPagingField(String fieldName, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("price").descending());
        return repository.findAllByNameContainingIgnoreCaseOrderByPriceDesc(fieldName, pageRequest);
    }
}
