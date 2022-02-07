package com.proiect.examen.dto;

import com.proiect.examen.model.PaymentStatus;
import com.proiect.examen.model.PaymentType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CreatePaymentDto {
    @NotBlank
    @Size(max = 100)
//    private PaymentType type;
    private String type;

    @NotBlank
    @Size(max = 200)
    private String customer;

    @Positive
    private double amount;

//    private PaymentStatus status;
    private String status;

    public CreatePaymentDto() {
    }

    public CreatePaymentDto(@NotBlank @Size(max = 100) String type, @NotBlank @Size(max = 200) String customer, @Positive double amount, String status) {
        this.type = type;
        this.customer = customer;
        this.amount = amount;
        this.status = status;
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
