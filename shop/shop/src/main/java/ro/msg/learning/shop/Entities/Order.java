package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_order")
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "shippedfrom_id", foreignKey = @ForeignKey(name="FK_CUSTOMERORDER_LOCATION"))
    private Location shippedFrom;

    @Column(name="customer_id")
    private Integer customer;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Embedded
    private Address address;
}
