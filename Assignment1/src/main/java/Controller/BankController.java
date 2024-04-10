package Controller;

import Service.BankService;
import Service.BankServiceImpl;

import java.util.Scanner;

import static java.lang.System.exit;

public class BankController {
    public void entranceBank(){
        BankService bankService = new BankServiceImpl();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println();
            System.out.println("원하시는 업무를 입력해주세요.");
            System.out.println("[은행가입] [예적금] [잔액조회] [전체계좌조회] [나가기]");
            String userInput = sc.nextLine().trim();
            MainAction action = MainAction.findByAction(userInput);
            if (action == null) {
                System.out.println("!!!올바른 업무를 입력해주세요!!!");
                continue;
            }
            switch (action) {
                case JOIN_BANK ->{
                    System.out.print("이름을 입력해주세요 : ");
                    String name = sc.nextLine();;
                    System.out.print("주민번호 앞자리를 입력해주세요 : ");
                    String birth = sc.nextLine();
                    bankService.join(name, birth);
                }
                case SAVINGS -> {
                    System.out.println("원하시는 업무를 입력해주세요.");
                    System.out.println("[계좌이체] [입금] [출금]");
                    userInput = sc.nextLine();
                    SavingAction savingAction = SavingAction.findByAction(userInput);
                    if (savingAction == null) {
                        System.out.println("!!!올바른 업무를 입력해주세요!!!");
                        continue;
                    }
                    switch (savingAction){
                        case TRANSFER->{
                            //todo: 계좌이체 서비스
                            System.out.print("고객님의 이름을 입력해주세요: ");
                            String name = sc.nextLine();
                            System.out.print("고객님의 생년월일을 입력해주세요: ");
                            String birth = sc.nextLine();
                            if(bankService.checkMember(name, birth)){
                                System.out.print("송금할 계좌번호를 입력하세요: ");
                                int account = Integer.parseInt(sc.nextLine());
                                System.out.print("송금할 금액을 입력하세요: ");
                                int money = Integer.parseInt(sc.nextLine());
                                bankService.transfer(name, birth, money, account);
                            }
                        }
                        case DEPOSIT ->{
                            System.out.print("입금할 계좌번호를 입력하세요: ");
                            int account = Integer.parseInt(sc.nextLine());
                            System.out.print("입금할 금액을 입력하세요: ");
                            int money = Integer.parseInt(sc.nextLine());
                            bankService.deposit(money, account);
                        }
                        case WITHDRAW ->{
                            System.out.print("출금할 계좌번호를 입력하세요: ");
                            int account = Integer.parseInt(sc.nextLine());
                            System.out.print("출금할 금액을 입력하세요: ");
                            int money = Integer.parseInt(sc.nextLine());
                            bankService.withdraw(money, account);
                        }
                    }
                }
                case SHOW_ALL_ACCOUNTS -> {
                    bankService.showAll();
                }
                case BALANCE -> {
                    System.out.print("고객님의 이름을 입력해주세요: ");
                    String name = sc.nextLine();
                    System.out.print("고객님의 생년월일을 입력해주세요: ");
                    String birth = sc.nextLine();
                    bankService.showBalance(name, birth);
                }
                case EXIT ->{
                    System.out.println("조심히 가십쇼.");
                    exit(0);
                }
            }
        }
    }
}
