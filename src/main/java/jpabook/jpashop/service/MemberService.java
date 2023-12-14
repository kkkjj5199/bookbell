package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;

//    회원가입
    @Transactional(readOnly = false)
    public Long join(Member member){
        memberRepository.save(member);
        validateDuplicate(member);
        return member.getId();
    }

    private void validateDuplicate(Member member){
        List<Member> findMembers = memberRepository.findByPhoneNumber(member.getPhone_number());
        if( !findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }
    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }
}
