package sopt.carrot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.carrot.Domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
