package com.proiect.examen.service;

import com.proiect.examen.exception.*;
import com.proiect.examen.model.Payment;
import com.proiect.examen.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment create(Payment payment) {
        verifyPaymentType(payment.getType());
        verifyPaymentStatus(payment.getStatus());

        if (payment.getAmount() < 0) {
            throw new PaymentAmountNegativeException();
        }

        return paymentRepository.save(payment);
    }

    public Payment cancel(Payment payment) {
        Payment existingPayment = paymentRepository.findById(payment.getId()).orElseThrow(() -> new PaymentNotFound());
        verifyPaymentType(payment.getType());

        if (existingPayment.getStatus().equalsIgnoreCase("CANCELLED")) {
            throw new PaymentAlreadyCancelledException();
        }

        payment.setStatus("CANCELLED");

        return paymentRepository.save(payment);
    }

    public List<Payment> get(String type, String status) {
        if (type != null && status != null) {
            return paymentRepository.findByTypeAndStatus(type, status);
        }

        if (type != null && status == null) {
            return paymentRepository.findByType(type);
        }

        if (type == null && status != null) {
            return paymentRepository.findByStatus(status);
        }

        return paymentRepository.findAll();
    }

    private void verifyPaymentType(String type) {
        if (!type.equalsIgnoreCase("ONLINE") &&
                !type.equalsIgnoreCase("POS")) {
            throw new WrongPaymentTypeException();
        }
    }

    private void verifyPaymentStatus(String status) {
        if (!status.equalsIgnoreCase("NEW") &&
                !status.equalsIgnoreCase("PROCESSED") &&
                !status.equalsIgnoreCase("CANCELLED")) {
            throw new WrongPaymentStatusException();
        }
    }
}
