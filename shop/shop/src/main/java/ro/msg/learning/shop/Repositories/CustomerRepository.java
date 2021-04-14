package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.Entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
