package sopt.carrot.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.carrot.like.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
