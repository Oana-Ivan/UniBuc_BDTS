package com.proiect.examen.mapper;

import com.proiect.examen.dto.CreatePaymentDto;
import com.proiect.examen.dto.CancelPaymentDto;
import com.proiect.examen.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public Payment create(CreatePaymentDto request) {
        return new Payment(request.getType(), request.getCustomer(), request.getAmount(), request.getStatus());
    }

    public Payment cancelPayment(CancelPaymentDto request) {
        return new Payment(request.getId(), request.getType(), request.getCustomer(), request.getAmount(), request.getStatus());
    }
}
