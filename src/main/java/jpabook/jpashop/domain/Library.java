package jpabook.jpashop.domain;


import jakarta.persistence.*;

import jdk.jfr.Category;
import jpabook.jpashop.domain.book.Book;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Library  extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "library_id")
    private Long id;

    private String name;

    private String Local;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "library_item",
    joinColumns = @JoinColumn(name = "library_id" ),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Library parent;

    @OneToMany(mappedBy = "parent")
    private List<Library> child = new ArrayList<>();


}
