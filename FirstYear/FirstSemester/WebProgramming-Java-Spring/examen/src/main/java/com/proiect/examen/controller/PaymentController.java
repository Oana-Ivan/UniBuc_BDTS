package com.proiect.examen.controller;

import com.proiect.examen.dto.CreatePaymentDto;
import com.proiect.examen.dto.CancelPaymentDto;
import com.proiect.examen.exception.InvalidUpdateRequestException;
import com.proiect.examen.mapper.PaymentMapper;
import com.proiect.examen.model.Payment;
import com.proiect.examen.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Validated
public class PaymentController {
    private PaymentService paymentService;
    private PaymentMapper paymentMapper;

    public PaymentController(PaymentService paymentService, PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @PostMapping
    public ResponseEntity<Payment> create(
            @Valid
            @RequestBody CreatePaymentDto request
            ) {
        Payment payment = paymentService.create(paymentMapper.create(request));
        return ResponseEntity.created(URI.create("/payment/" + payment.getId())).body(payment);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Payment> cancelPayment(
            @PathVariable long id,
            @Valid
            @RequestBody CancelPaymentDto request
    ) {

        if (id != request.getId()) {
            throw new InvalidUpdateRequestException();
        }

        return ResponseEntity.ok(paymentService.cancel(paymentMapper.cancelPayment(request)));
    }

    @GetMapping
    public List<Payment> get(@RequestParam(required = false) String type,
                             @RequestParam(required = false) String status) {
        return paymentService.get(type, status);
    }
}
