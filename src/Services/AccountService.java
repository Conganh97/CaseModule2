package Services;

import Models.Account;
import ValiDate.ValiDate;
import io.ReadAndWrite;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountService {
    Scanner sc = new Scanner(System.in);
    public static ArrayList <Account> accounts = new ArrayList<>();

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
        System.out.println("Add account " + account.getUserName() + " success");
        readAndWrite.write(accounts,"account.csv");
    }
    public ArrayList <Account> findAll (){
        return accounts;
    }

    public boolean login() {
        System.out.println("Enter user name: (User name must have 6-10 letter include letters and numbers)");
        String user = ValiDate.validateString(ValiDate.REGEX_ACCOUNT);
        System.out.println("Enter pass word : (Password must have 6-10 letter include letters and numbers)");
        String pass = ValiDate.validateString(ValiDate.REGEX_ACCOUNT);

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
        System.out.println("Enter name: (Name must have at least 1 uppercase letter and no number) ");
        String name = ValiDate.validateString(ValiDate.REGEX_STRING);
        while (true) {
            System.out.println("Enter user name: (User name must have 6-10 letter include letters and numbers)");
            user = ValiDate.validateString(ValiDate.REGEX_ACCOUNT);
            if (checkUserName(user)) {
                break;
            }else {
                System.err.println("User name is exist");
            }
        }
        System.out.println("Enter pass word : (Password must have 6-10 letter include letters and numbers)");
        String pass = ValiDate.validateString(ValiDate.REGEX_ACCOUNT);
        System.out.println("Enter email: (Email must be in the form: abcd@abc.com/vn)" );
        String email = ValiDate.validateString(ValiDate.REGEX_EMAIL);
        return new Account(name, user, pass,email,"user");
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
        System.out.println("Enter user name need search (User name must have 6-10 letter include letters and numbers)");
        String user = ValiDate.validateString(ValiDate.REGEX_ACCOUNT);
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(user)) return i;
        } return -1;
    }

    public void deleteAccount (int index){
        if (index != -1) {
            accounts.remove(index);
            System.out.println("Delete account success");
            readAndWrite.write(accounts,"account.csv");
        } else System.out.println("This account not exist");
    }

    public void displayAccount (){
        System.out.println("-------------------------------Account list-------------------------------");
        System.out.printf("| %-15s| %-15s| %-15s| %-15s| %-15s" ,"Name","User","Password","Rights","Email");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        for (Account acc: accounts) {
            System.out.printf("| %-15s| %-15s| %-15s| %-15s| %-15s",acc.getName(),acc.getUserName(),acc.getPassWord(),acc.getRights(),acc.getEmail());
            System.out.println();
            System.out.println("--------------------------------------------------------------------------");
        }
    }

    public void editAccount (int index){
        if (index != -1 ){
            accounts.set(index,createAccount());
            System.out.println("Edit account success");
            readAndWrite.write(accounts,"account.csv");
        } else System.out.println("This account not exist");
    }
}
