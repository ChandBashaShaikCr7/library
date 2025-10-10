package com.konic.library.service;

import com.konic.library.entity.Member;
import com.konic.library.exception.ResourceNotFoundException;
import com.konic.library.repository.MemberRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member addMember(Member member) {
        member.setMembershipDate(LocalDate.now());
        member.setStatus("Active");
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found"));
    }

    public Member updateMember(Long id, Member memberDetails) {
        Member member = getMemberById(id);
        member.setName(memberDetails.getName());
        member.setEmail(memberDetails.getEmail());
        member.setPhNo(memberDetails.getPhNo());
        member.setStatus(memberDetails.getStatus());
        return memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
