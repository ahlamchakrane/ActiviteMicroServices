package com.example.ahlamchakrane_aactivitepratique2;

import com.example.ahlamchakrane_aactivitepratique2.dto.InvoiceRequestDTO;
import com.example.ahlamchakrane_aactivitepratique2.service.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class AhlamChakraneAActivitePratique2Application {

    public static void main(String[] args) {
        SpringApplication.run(AhlamChakraneAActivitePratique2Application.class, args);
    }
   /*@Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return  args -> {
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(9000), "id"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(9000), "id2"));
        };
    }*/
}
