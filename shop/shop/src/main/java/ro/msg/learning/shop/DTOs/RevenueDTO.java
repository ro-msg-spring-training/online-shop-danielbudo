package ro.msg.learning.shop.DTOs;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
public class RevenueDTO implements Serializable {
    private Integer id;
    private LocationDTO location;
    private LocalDateTime date;
    private BigDecimal sum;
}
