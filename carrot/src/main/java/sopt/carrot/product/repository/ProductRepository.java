package sopt.carrot.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.carrot.product.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
