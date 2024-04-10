package Repository;

import Data.Member;

import java.util.*;

public class MemoryBankRepository  implements BankRepository{
    private static HashMap<Integer, Member> bank = new HashMap<>();
    private static Long id = 0L;

    @Override
    public Member join(Member member) {
        member.setId(id++);
        member.setEnterDate(new Date());
        member.setAccount((int)(Math.random()*10000000));
        bank.put(member.getAccount(), member);
        return member;
    }

    public List<Member> findAll(){
        return new ArrayList<>(bank.values());
    }

    @Override
    public Optional<Member> findByAccount(int account) {
        return Optional.ofNullable(bank.get(account));
    }


    @Override
    public Optional<Member> findMember(String name, String birth) {
        Optional<Member> member = bank.values().stream()
                .filter(m -> m.getName().equals(name) && m.getBirth().equals(birth))
                .findAny();
        return member;
    }

    @Override
    public int deposit(Member member, int money) {
        member.setBalance(member.getBalance()+money);
        return member.getBalance();
    }

    @Override
    public void withdraw(Member member, int money) {
        member.setBalance(member.getBalance()-money);
    }
}
