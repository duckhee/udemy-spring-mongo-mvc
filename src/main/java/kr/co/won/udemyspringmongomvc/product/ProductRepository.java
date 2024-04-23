package kr.co.won.udemyspringmongomvc.product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigDecimal;
import java.util.List;


public interface ProductRepository extends MongoRepository<Product, String> {

    /**
     * 대문자 소문자를 구분하지 않고 값을 가져오는 것
     */
    List<Product> findAllByNameIgnoreCase(String productName);

    /**
     * 해당 단어로 시작하는 모든 값을 찾아오는 것
     * regex
     * => ^productName
     */
    List<Product> findAllByNameStartingWith(String productName);

    /**
     * 해당 단어로 끝나는 모든 값을 찾아오는 것
     * regex
     * => productName$
     */
    List<Product> findAllByNameEndingWith(String productName);

    /**
     * 해당 되는 단어를 포함하고 있는 모든 값을 찾아 오는 것
     * regex
     * => /^productName$/i
     */
    List<Product> findAllByNameContainingIgnoreCase(String productName);

    /**
     * 해당 값보다 작은 값을 모두 찾아 오는 것
     * price > database data
     */
    List<Product> findAllByPriceLessThan(BigDecimal price);

    /**
     * 해당 값보다 큰 값을 모두 찾아 오는 것
     * price < database data
     */
    List<Product> findAllByPriceGreaterThan(BigDecimal price);

    /**
     * 해당 값 사이에 있는 값을 모두 가져오는 것
     * min < database data < max
     */
    List<Product> findAllByPriceBetween(BigDecimal min, BigDecimal max);

    /**
     * 해당 되는 단어를 포함하고 있는 모든 값을 찾아 와서 이름 값으로 오름차순 정렬 것
     * regex
     * => /^productName$/i order by price desc
     */
    List<Product> findAllByNameContainingIgnoreCaseOrderByPriceDesc(String productName);

    /**
     * 해당 되는 단어를 포함하고 있는 모든 값을 찾아 와서 이름 값으로 오름차 순 정렬로 pagination 형태로 가져오기
     * regex
     * => /^productName$/i order by price desc
     */
    List<Product> findAllByNameContainingIgnoreCaseOrderByPriceDesc(String productName, Pageable pageable);

}
