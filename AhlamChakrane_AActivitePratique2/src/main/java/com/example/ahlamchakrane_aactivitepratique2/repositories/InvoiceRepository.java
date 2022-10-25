package com.example.ahlamchakrane_aactivitepratique2.repositories;

import java.util.List;

import com.example.ahlamchakrane_aactivitepratique2.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    List<Invoice> findByCustomerId(String customerId);
}
