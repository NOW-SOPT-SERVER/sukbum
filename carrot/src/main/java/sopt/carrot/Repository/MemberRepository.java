package sopt.carrot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.carrot.Domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
