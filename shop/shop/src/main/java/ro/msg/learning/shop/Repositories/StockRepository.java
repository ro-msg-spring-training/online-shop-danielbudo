package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.Entities.Location;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Entities.Stock;
import ro.msg.learning.shop.Entities.StockId;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockId> {

    Stock findStockByProductIdAndLocationId(Integer productId, Integer locationId);

    // Find a stock containing a product, with that location, and that has quantity >= than the argument quantity (used for Single Location strategy)
    Stock findStockByProductIdAndQuantityGreaterThanEqualAndLocationId(Product productId, Integer quantity, Location locationId);
    
    // Find the stock(s) that contain a product and a quantity >= than the argument quantity.
    // Sort the stocks in descendent order of their quantity. (used for Most Abundant strategy)
    List<Stock> findStockByProductIdAndQuantityGreaterThanEqualOrderByQuantityDesc(Integer productId, Integer quantity);
}