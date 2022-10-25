package ma.enset.ahlamchakrane_activitepratique1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.enset.ahlamchakrane_activitepratique1.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
