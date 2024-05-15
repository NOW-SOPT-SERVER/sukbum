package sopt.carrot.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.carrot.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
