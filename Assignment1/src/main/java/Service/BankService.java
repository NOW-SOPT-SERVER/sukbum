package Service;

import Data.Member;

import java.util.List;

public interface BankService {
    void join(String name, String birth);
    void deposit(int money, int account);
    void withdraw(int money, int account);
    void showAll();
    void showBalance(String name, String birth);

    boolean checkMember(String name, String birth);

    void transfer(String name, String birth, int money, int account);
}
