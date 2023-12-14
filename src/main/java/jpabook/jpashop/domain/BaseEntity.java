package jpabook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public  abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false, insertable = false)
    private LocalDateTime created_date;

    @Column(updatable = false, insertable = false)
    private LocalDateTime updated_date;
}
