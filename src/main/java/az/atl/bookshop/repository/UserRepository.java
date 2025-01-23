package az.atl.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import az.atl.bookshop.entities.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email); // Non-static method declaration
    // Uncomment if needed
    // Optional<UserEntity> findByFullName(String fullName);
}
