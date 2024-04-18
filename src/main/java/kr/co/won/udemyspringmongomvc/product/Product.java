package kr.co.won.udemyspringmongomvc.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Product {

    private String id;

    private String name;

    private String description;
}
