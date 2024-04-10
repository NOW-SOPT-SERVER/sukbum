package Data;

import java.util.Date;

public class Member {
    private Long id;
    private String name;
    private Date enterDate;
    private String birth;
    private int account;
    private int balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "[고객ID] " + id  +
                " [이름] " + name +
                " [생년월일] " + birth +
                " [가입날짜] " + enterDate +
                " [계좌번호] " + account +
                " [잔액] " + balance +"원";
    }

    public Member(String name, String birth){
        this.name = name;
        this.birth = birth;
    }
}
