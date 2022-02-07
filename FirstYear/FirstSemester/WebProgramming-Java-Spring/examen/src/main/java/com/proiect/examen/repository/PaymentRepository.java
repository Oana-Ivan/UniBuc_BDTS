package com.proiect.examen.repository;

import com.proiect.examen.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByType(String status);
    List<Payment> findByStatus(String status);
    List<Payment> findByTypeAndStatus(String type, String status);
}
