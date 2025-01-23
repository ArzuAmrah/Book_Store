package az.atl.bookshop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WishlistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private ProductEntity product;
}
