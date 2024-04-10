package Service;

import Data.Member;
import Repository.MemoryBankRepository;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public class BankServiceImpl implements BankService{
    MemoryBankRepository memoryBankRepository = new MemoryBankRepository();
    @Override
    public void join(String name, String birth) {
        Member member = new Member(name, birth.trim());
        Optional<Member> already = memoryBankRepository.findMember(name, birth);
        if (already.isEmpty()) {
            memoryBankRepository.join(member);
            System.out.println("성공적으로 가입되었습니다!");
            System.out.println("가입정보: "+ member);
        }
        else{
            System.out.println("이미 가입되어 있는 고객입니다.");
        }
    }

    @Override
    public void deposit(int money, int account){
        Optional<Member> member = memoryBankRepository.findByAccount(account);
        if (memoryBankRepository.findByAccount(account).isEmpty()) {
            System.out.println("존재하지 않는 계좌번호입니다.");
        }else {
            int afterBalance = memoryBankRepository.deposit(member.get(), money);
            System.out.println(afterBalance+"원이 성공적으로 입금되었습니다. 잔액: "+member.get().getBalance()+"원");
        }
    }

    @Override
    public void withdraw(int money, int account) {
        Optional<Member> member = memoryBankRepository.findByAccount(account);
        if (memoryBankRepository.findByAccount(account).isEmpty()) {
            System.out.println("존재하지 않는 계좌번호입니다.");
        }else {
            if (money > member.get().getBalance()){
                System.out.println("잔액 이상의 금액은 출금할 수 없습니다. 잔액: "+member.get().getBalance()+"원");
            }else {
                memoryBankRepository.withdraw(member.get(), money);
                System.out.println(money+"원이 성공적으로 출금되었습니다. 잔액: "+member.get().getBalance()+"원");
            }
        }
    }

    @Override
    public void showAll() {
        List<Member> members = memoryBankRepository.findAll();
        if ((long) members.size() == 0) {
            System.out.println("아직 조회할 계좌 정보가 없습니다.");
        }
        for (Member member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void showBalance(String name, String birth) {
        Optional<Member> member = memoryBankRepository.findMember(name, birth.trim());
        if (member.isEmpty()) {
            System.out.println("계좌 정보가 존재하지 않습니다.");
        }else{
            System.out.println(member.get().getName()+"님의 잔액은 "+member.get().getBalance()+"원 입니다.");
        }
    }

    @Override
    public boolean checkMember(String name, String birth) {
        Optional<Member> member = memoryBankRepository.findMember(name, birth);
        if (member.isEmpty()) {
            System.out.println("고객 정보가 일치하지 않습니다.");
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void transfer(String name, String birth, int money, int account) {
        Optional<Member> toMember = memoryBankRepository.findByAccount(account);
        if (toMember.isEmpty()) {
            System.out.println("존재하지 않는 계좌번호입니다.");
        }else {
            Optional<Member> fromMember = memoryBankRepository.findMember(name, birth);
            if (money > fromMember.get().getBalance()){
                System.out.println("잔액이 부족합니다. 잔액: "+fromMember.get().getBalance()+"원");
            }else{
                toMember.get().setBalance(toMember.get().getBalance()+money);
                fromMember.get().setBalance(fromMember.get().getBalance()-money);
                System.out.println("성공적으로 이체되었습니다.");
            }
        }
    }
}
