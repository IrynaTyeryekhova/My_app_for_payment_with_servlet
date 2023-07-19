package org.example.entities;

public class CardAccount {
    private String number;
    private double balance;
    private String validityPeriod;
    private String password;
    private String status;
    private String clientId;
    private int id;

    public CardAccount(String number, double balance, String validilyPeriod) {
        this.number = number;
        this.balance = balance;
        this.validityPeriod = validilyPeriod;

    }

    public CardAccount(String number, double balance, String validilyPeriod, String password) {
        this.number = number;
        this.balance = balance;
        this.validityPeriod = validilyPeriod;
        this.password = password;
    }

    public CardAccount(String number, double balance, String validilyPeriod, String password, String status, String clientId) {
        this.number = number;
        this.balance = balance;
        this.validityPeriod = validilyPeriod;
        this.password = password;
        this.status = status;
        this.clientId = clientId;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public double getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
    public String getStatus() {
        return status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
