package sopt.carrot.member.repository;

import sopt.carrot.member.domain.Member;

public interface MemberRepositoryCustom {
    Member findByMemberId(Long memberId);
}
