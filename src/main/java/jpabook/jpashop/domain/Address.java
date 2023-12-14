package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address extends BaseEntity{

    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    // setter 를 제거하고 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스 생성.
        //이유 : 리플랙션,프록시 같은 기술을 사용할 수 있도록 지원해야 한다.
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
