package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.book.Book;
import lombok.Getter;

@Entity
@Getter
public class OrderBook {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int count;  // 수량

}
