package kr.co.won.udemyspringmongomvc.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import kr.co.won.udemyspringmongomvc.category.Category;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Document
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private List<String> tags;

    @DBRef
    private Category category;
}
