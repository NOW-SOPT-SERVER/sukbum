package sopt.carrot.Service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.carrot.Domain.Dto.MemberCreateDto;
import sopt.carrot.Domain.Member;
import sopt.carrot.Repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional
    public String create(MemberCreateDto memberCreateDto){
        Member member = Member.create(memberCreateDto.name(), memberCreateDto.phoneNumber());
        memberRepository.save(member);
        return member.getId().toString();
    }
}
