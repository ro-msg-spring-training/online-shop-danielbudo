package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.Entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
