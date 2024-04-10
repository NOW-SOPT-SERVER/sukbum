package Repository;

import Data.Member;

import java.util.List;
import java.util.Optional;

public interface BankRepository {
    Member join(Member member);
    List<Member> findAll();

    Optional<Member> findByAccount(int account);
    Optional<Member> findMember(String name, String birth);
    int deposit(Member member, int money);

    void withdraw(Member member, int money);
}
