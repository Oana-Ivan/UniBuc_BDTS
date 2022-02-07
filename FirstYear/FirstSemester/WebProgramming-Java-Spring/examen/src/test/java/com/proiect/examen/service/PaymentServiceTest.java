package com.proiect.examen.service;

import com.proiect.examen.exception.PaymentAmountNegativeException;
import com.proiect.examen.exception.WrongPaymentStatusException;
import com.proiect.examen.exception.WrongPaymentTypeException;
import com.proiect.examen.model.Payment;
import com.proiect.examen.repository.PaymentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    @DisplayName("created successfully")
    void create() {
        //arrange
        Payment payment = new Payment("ONLINE", "C2", 20, "NEW");
        Payment returnedPayment = new Payment(1, "ONLINE", "C2", 20, "NEW");

        Mockito.when(paymentRepository.save(payment)).thenReturn(returnedPayment);


        // act
        Payment result = paymentService.create(payment);

        // assert
        assertNotNull(result);
        assertEquals(returnedPayment.getId(), result.getId());
        assertEquals(returnedPayment.getAmount(), result.getAmount());
        assertEquals(returnedPayment.getStatus(), result.getStatus());
        assertEquals(returnedPayment.getType(), result.getType());
        assertEquals(returnedPayment.getCustomer(), result.getCustomer());

        Mockito.verify(paymentRepository).save(payment);
    }

    @Test
    @DisplayName("Payment amount must not be negative")
    void createThrowsPaymentAmountNegativeException() {
        //arrange
        Payment payment = new Payment("ONLINE", "C2", -20, "NEW");

        //act
        PaymentAmountNegativeException exception = assertThrows(PaymentAmountNegativeException.class,
                () -> paymentService.create(payment));

        // assert
        assertNotNull(exception);
        assertEquals("Payment amount must not be negative", exception.getMessage());

        verify(paymentRepository, times(0)).save(payment);
    }

    @Test
    @DisplayName("WrongPaymentTypeException")
    void createThrowsWrongPaymentTypeException() {
        //arrange
        Payment payment = new Payment("ABC", "C2", 20, "NEW");

        //act
        WrongPaymentTypeException exception = assertThrows(WrongPaymentTypeException.class,
                () -> paymentService.create(payment));

        // assert
        assertNotNull(exception);
        assertEquals("The type must by \"ONLINE\" or \"POS\"", exception.getMessage());

        verify(paymentRepository, times(0)).save(payment);
    }

    @Test
    @DisplayName("WrongPaymentTypeException")
    void createThrowsWrongPaymentStatusException() {
        //arrange
        Payment payment = new Payment("ONLINE", "C2", 20, "ABC");

        //act
        WrongPaymentStatusException exception = assertThrows(WrongPaymentStatusException.class,
                () -> paymentService.create(payment));

        // assert
        assertNotNull(exception);
        assertEquals("The status must by \"NEW\" or \"PROCESSED\" or \"CANCELLED\"", exception.getMessage());

        verify(paymentRepository, times(0)).save(payment);
    }

    @Test
    @DisplayName("success")
    void cancel() {
//        Payment oldPayment = new Payment("ONLINE", "C2", 20, "NEW");
//        Payment newPayment = new Payment("ONLINE", "C2", 20, "CANCELLED");
//
//        Mockito.when(paymentRepository.save(newPayment)).thenReturn(newPayment);
//
//        //act
//        Payment result = paymentService.cancel(oldPayment);
//
//        //assert
//        assertNotNull(result);
//        assertEquals(newPayment.getId(), result.getId());
//        assertEquals(newPayment.getAmount(), result.getAmount());
//        assertEquals(newPayment.getStatus(), result.getStatus());
//        assertEquals(newPayment.getType(), result.getType());
//        assertEquals(newPayment.getCustomer(), result.getCustomer());
//        assertEquals(result.getStatus(), "CANCELLED");
//
//        verify(paymentRepository).save(newPayment);
    }

    @Test
    void get() {
    }
}