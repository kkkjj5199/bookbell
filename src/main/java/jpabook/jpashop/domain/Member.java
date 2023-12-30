package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member  extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String password;

    private String email;

    @Embedded
    private Address address;

    private String phone_number;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    private String provider;
    private String providerId;

    @Builder
    public Member(String name, String password, String email, Address address,String phone_number,MemberRole role, List<Order> orders, String provider, String providerId
    ){
        this.name=name;
        this.password = password;
        this.email = email;
        this.address=address;
        this.phone_number=phone_number;
        this.role=role;
        this.orders=orders;
        this.provider=provider;
        this.providerId=providerId;
    }




    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() { return  password;}

    public Address getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public MemberRole getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getProvider() {
        return provider;
    }

    public String getProviderId() {
        return providerId;
    }
}
