package Services;

import Models.Account;
import io.ReadAndWrite;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountService {
    Scanner sc = new Scanner(System.in);
    ArrayList <Account> accounts = new ArrayList<>();

    public static Account account;

    ReadAndWrite readAndWrite = new ReadAndWrite();
//    {
//        accounts.add(new Account("Admin","admin","admin","admin","admin"));
//        readAndWrite.write(accounts,"account.csv");
//    }

    public AccountService() {
        accounts = readAndWrite.read( accounts, "account.csv");
    }

    public void addAccount (Account account){
        for (Account acc : accounts) {
            if (acc.getUserName().equals(account.getUserName())){
                return;
            }
        }
        accounts.add(account);
        readAndWrite.write(accounts,"account.csv");
    }
    public ArrayList <Account> findAll (){
        return accounts;
    }

    public boolean login() {
        System.out.println("Enter userName :");
        String user = sc.nextLine();
        System.out.println("Enter passWord :");
        String pass = sc.nextLine();

        for (Account acc : accounts) {
            if (acc.getUserName().equals(user) && acc.getPassWord().equals(pass)) {
                AccountService.account = acc;
                return true;
            }
        }
        return false;
    }
    public Account createAccount() {
        String user = null;
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        while (true) {
            System.out.println("Enter user name :");
            user = sc.nextLine();
            if (checkUserName(user)) {
                break;
            }else {
                System.err.println("User name is exist");
            }
        }
        System.out.println("Enter pass word :");
        String pass = sc.nextLine();
        System.out.println("Enter email");
        String email = sc.nextLine();
        return new Account(name, user, pass, "user",email);
    }

    public boolean checkUserName(String userName) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }
    public int findIndex (){
        System.out.println("Enter user name need search");
        String user = sc.nextLine();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(user)) return i;
        } return -1;
    }

    public void deleteAccount (int index){
        if (index != -1) {
            accounts.remove(index);
        } else System.out.println("This account not exist");
    }

    public void displayAccount (){
        for (Account acc: accounts) {
            System.out.println(acc);
        }
    }

    public void editAccount (int index){
        if (index != -1 ){
            accounts.set(index,createAccount());
        } else System.out.println("This account not exist");
    }
}
