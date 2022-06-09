package Models;

import java.io.Serializable;

public class Account implements Serializable {

    private String name;
    private String userName;
    private String passWord;
    private String rights;
    private String email;

    public Account(String name, String userName, String passWord, String email, String rights) {
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.rights = rights;
    }

    public Account() {
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", rights='" + rights + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
