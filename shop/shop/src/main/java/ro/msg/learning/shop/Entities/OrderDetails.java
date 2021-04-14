package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Data @Builder
@EqualsAndHashCode @ToString
@Table(name = "orderdetail")
@IdClass(OrderDetailsId.class)
public class OrderDetails implements Serializable {
    @Id
    @ManyToOne @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "FK_ORDERDETAIL_ORDER"))
    private Order orderId;

    @Id
    @ManyToOne @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_ORDERDETAIL_PRODUCT"))
    private Product productId;
    private Integer quantity;
}