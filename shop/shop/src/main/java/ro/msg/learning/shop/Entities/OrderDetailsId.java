package ro.msg.learning.shop.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class OrderDetailsId implements Serializable {
    @Id @Column(name = "order_id")
    private Integer orderId;

    @Id @Column(name = "product_id")
    private Integer productId;
}
