package com.proiect.examen.model;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    private PaymentType type;
    private String type;

    private String customer;

    private double amount;

//    private PaymentStatus status;
    private String status;

    public Payment() {
    }

    public Payment(long id, String type, String customer, double amount, String status) {
        this.id = id;
        this.type = type;
        this.customer = customer;
        this.amount = amount;
        this.status = status;
    }

    public Payment(String type, String customer, double amount, String status) {
        this.type = type;
        this.customer = customer;
        this.amount = amount;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
