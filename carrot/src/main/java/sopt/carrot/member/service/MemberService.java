package sopt.carrot.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.carrot.location.domain.Location;
import sopt.carrot.location.service.LocationService;
import sopt.carrot.member.dto.MemberCreateDto;
import sopt.carrot.member.domain.Member;
import sopt.carrot.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final LocationService locationService;
    @Transactional
    public String create(MemberCreateDto memberCreateDto){
        Location location = locationService.checkLocationExists(memberCreateDto.location());
        Member member = Member.create(memberCreateDto.name(), memberCreateDto.phoneNumber(), location);
        memberRepository.save(member);
        return member.getId().toString();
    }
}
