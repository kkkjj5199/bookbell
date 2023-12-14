package jpabook.jpashop.domain.book;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("C")
@Getter
public class Cd extends Book{
    private String title;
    private String author;
}
