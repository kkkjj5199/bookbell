package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    private String phone_number;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();











    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
