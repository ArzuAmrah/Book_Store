package az.atl.bookshop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private CategoryEntity category;

    private String author;
    private Double price;
    private String description;
}
