package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    @Transactional
    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
       return   em.find(Member.class,id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByPhoneNumber(String phoneNumber){
        return em.createQuery("select m from Member m where m.phone_number=:phoneNumber", Member.class )
                .setParameter("phoneNumber",phoneNumber)
                .getResultList();
    }








}
