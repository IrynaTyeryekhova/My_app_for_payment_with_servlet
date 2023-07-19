package org.example.entities;

public class Payment {
    private int id;
    private double sum;
    private String date;
    private String purposePayment;
    private String clientEMail;
    private String cardNumber;
    private String status;


    public Payment(double sum, String date) {
        this.sum = sum;
        this.date = date;
    }
    public Payment(double sum, String date, String status, String cardNumber) {
        this.sum = sum;
        this.date = date;
        this.status = status;
        this.cardNumber = cardNumber;
    }
    public Payment(String date, double sum, String purposePayment, String clientEMail, String cardNumber, String status) {
        this.date = date;
        this.sum = sum;
        this.purposePayment = purposePayment;
        this.clientEMail = clientEMail;
        this.cardNumber = cardNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPurposePayment() {
        return purposePayment;
    }

    public void setPurposePayment(String purposePayment) {
        this.purposePayment = purposePayment;
    }

    public String getClientEMail() {
        return clientEMail;
    }

    public void setClientEMail(String clientEMail) {
        this.clientEMail = clientEMail;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
