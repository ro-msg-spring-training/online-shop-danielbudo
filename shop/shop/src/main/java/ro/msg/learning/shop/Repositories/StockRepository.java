package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.Entities.Stock;
import ro.msg.learning.shop.Entities.StockId;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockId> {
}
