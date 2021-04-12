package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
public class Revenue {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne @JoinColumn(name = "location_id")
    private Location location;
    private LocalDateTime date;
    private BigDecimal sum;
}
