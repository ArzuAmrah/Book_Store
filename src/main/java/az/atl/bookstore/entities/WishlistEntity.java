package az.atl.bookstore.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "wishlists")
public class WishlistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private ProductEntity product;
}
