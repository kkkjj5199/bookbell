package jpabook.jpashop.domain.book;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Library;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
public abstract class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    private String title;

    private String author;

    private String ISBN;

    private int stockQuantity;

    private LocalDateTime published_date;

    @ManyToMany(mappedBy = "books")
    private List<Library> libraryList = new ArrayList<>();


}
