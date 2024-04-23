package kr.co.won.udemyspringmongomvc.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/method-queries")
@RequiredArgsConstructor
public class QueryMethodController {

    private final QueryMethodService queryMethodService;


    @GetMapping(path = "/search/is")
    public ResponseEntity<List<Product>> searchByName(@RequestParam(name = "name") String name) {
        List<Product> products = queryMethodService.searchByName(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/search/starts-with")
    public ResponseEntity<List<Product>> searchByNameStartsWith(@RequestParam(name = "name") String name) {
        List<Product> products = queryMethodService.searchByNameStartingWith(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/search/ends-with")
    public ResponseEntity<List<Product>> searchByNameEndsWith(@RequestParam(name = "name") String name) {
        List<Product> products = queryMethodService.searchByNameEndingWith(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/search/containing")
    public ResponseEntity<List<Product>> searchByNameContaining(@RequestParam(name = "name") String name) {
        List<Product> products = queryMethodService.searchByNameContaining(name);
        return ResponseEntity.ok(products);
    }


    @GetMapping(path = "/search/little")
    public ResponseEntity<List<Product>> searchByLittle(@RequestParam(name = "price") BigDecimal price) {
        List<Product> products = queryMethodService.searchByPriceLittle(price);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/search/greater-then")
    public ResponseEntity<List<Product>> searchByGreaterThen(@RequestParam(name = "price") BigDecimal price) {
        List<Product> products = queryMethodService.searchByPriceGreaterThan(price);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/search/between")
    public ResponseEntity<List<Product>> searchByPriceBetween(@RequestParam(name = "min") BigDecimal min, @RequestParam(name = "max") BigDecimal max) {
        List<Product> products = queryMethodService.searchByPriceBetween(min, max);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/sort/asc")
    public ResponseEntity<List<Product>> sortByProduct(@RequestParam(name = "field") String field) {
        List<Product> products = queryMethodService.sortByField(field);
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/sort-page")
    public ResponseEntity<List<Product>> sortByProductPage(@RequestParam(name = "field") String field, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        List<Product> products = queryMethodService.sortByPagingField(field, page, size);
        return ResponseEntity.ok(products);
    }
}
