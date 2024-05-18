package sopt.carrot.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import sopt.carrot.common.exception.ErrorMessage;
import sopt.carrot.common.exception.NotFoundException;
import sopt.carrot.member.domain.Member;
import sopt.carrot.member.domain.QMember;
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    public MemberRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    QMember qMember = QMember.member;
    @Override
    public Member findByMemberId(Long memberId) {
        Member member = queryFactory.selectFrom(qMember)
                .where(qMember.id.eq(memberId))
                .fetchOne();
        if (member == null) {
            throw new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION);
        }
        return member;
    }
}
