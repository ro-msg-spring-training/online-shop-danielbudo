package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
@IdClass(StockId.class)
public class Stock implements Serializable {
    @Id @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_STOCK"))
    private Product productId;

    @Id @ManyToOne
    @JoinColumn(name = "location_id", foreignKey = @ForeignKey(name = "FK_LOCATION_STOCK"))
    private Location locationId;
    private Integer quantity;
}
