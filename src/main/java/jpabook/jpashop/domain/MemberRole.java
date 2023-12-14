package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRole {
    ROLE_USER,
    ROLE_ADMIN
}
