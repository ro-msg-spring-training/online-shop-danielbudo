package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.Entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
