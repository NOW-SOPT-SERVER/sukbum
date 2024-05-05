package sopt.carrot.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.carrot.member.dto.MemberCreateDto;
import sopt.carrot.member.domain.Member;
import sopt.carrot.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional
    public String create(MemberCreateDto memberCreateDto){
        Member member = Member.create(memberCreateDto.name(), memberCreateDto.phoneNumber(), memberCreateDto.location());
        memberRepository.save(member);
        return member.getId().toString();
    }
}
