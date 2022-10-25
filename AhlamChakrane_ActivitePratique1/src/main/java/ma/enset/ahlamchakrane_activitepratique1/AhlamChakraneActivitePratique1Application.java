package ma.enset.ahlamchakrane_activitepratique1;

import ma.enset.ahlamchakrane_activitepratique1.dto.CustomerRequestDTO;
import ma.enset.ahlamchakrane_activitepratique1.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AhlamChakraneActivitePratique1Application {

    public static void main(String[] args) {
        SpringApplication.run(AhlamChakraneActivitePratique1Application.class, args);
    }
    //http://localhost:8882/swagger-ui/index.html
    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("id", "name", "email"));
            customerService.save(new CustomerRequestDTO("id2", "name2", "email2"));
            customerService.save(new CustomerRequestDTO("id3", "name3", "email3"));
        };
    }

}
