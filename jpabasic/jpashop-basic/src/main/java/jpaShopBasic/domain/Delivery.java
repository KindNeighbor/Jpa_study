package jpaShopBasic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;
    private String street;
    private String zipcode;

    private DeliveryStatus status;
}
