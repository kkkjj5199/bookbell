package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class Delivery  extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "deliver_id")
    private Long id;

    @OneToOne(mappedBy = "delivery",fetch =FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; // READY, SUCCESS,
}
