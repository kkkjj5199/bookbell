package jpabook.jpashop.domain.book;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("A")
@Getter
public class Album extends Book{

    private String title;
    private String author;


}
