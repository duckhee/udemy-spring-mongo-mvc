package kr.co.won.udemyspringmongomvc.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final SearchService searchService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping(path = "/{product-id}")
    public ResponseEntity<Product> findById(@PathVariable(name = "product-id") String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping(path = "/{product-id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "product-id") String id) {
        productService.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(path = "/search/is")
    public ResponseEntity<List<Product>> searchByName(@RequestParam(name = "name") String name) {
        List<Product> products = searchService.searchByName(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/search/starts-with")
    public ResponseEntity<List<Product>> searchByNameStartsWith(@RequestParam(name = "name") String name) {
        List<Product> products = searchService.searchByNameStartingWith(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/search/ends-with")
    public ResponseEntity<List<Product>> searchByNameEndsWith(@RequestParam(name = "name") String name) {
        List<Product> products = searchService.searchByNameEndingWith(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/search/little")
    public ResponseEntity<List<Product>> searchByLittle(@RequestParam(name = "price") BigDecimal price) {
        List<Product> products = searchService.searchByPriceLittle(price);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/search/greater-then")
    public ResponseEntity<List<Product>> searchByGreaterThen(@RequestParam(name = "price") BigDecimal price) {
        List<Product> products = searchService.searchByPriceGreaterThan(price);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/sort/asc")
    public ResponseEntity<List<Product>> sortByProduct(@RequestParam(name = "field") String field) {
        List<Product> products = searchService.sortByField(field);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/sort-page")
    public ResponseEntity<List<Product>> sortByProductPage(@RequestParam(name = "field") String field, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        List<Product> products = searchService.sortByPagingField(field, page, size);
        return ResponseEntity.ok(products);
    }
}
