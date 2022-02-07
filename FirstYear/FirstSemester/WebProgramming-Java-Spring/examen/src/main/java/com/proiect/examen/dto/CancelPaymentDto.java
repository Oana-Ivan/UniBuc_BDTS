package com.proiect.examen.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CancelPaymentDto extends CreatePaymentDto{
    @NotNull
    private long id;

    public CancelPaymentDto(@NotBlank @Size(max = 100) String type, @NotBlank @Size(max = 200) String customer, @Positive double amount, String status, @NotNull long id) {
        super(type, customer, amount, status);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
