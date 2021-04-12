package ro.msg.learning.shop.Entities;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
@Data
public class StockId implements Serializable {
    @Column(name = "Product_Id")
    private Integer productId;

    @Column(name = "Location_Id")
    private Integer locationId;

}
