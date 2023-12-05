package hello.core.member;

public class MemberServiceImple implements MemberService{
    //멤버 리포지토리만 있음. 즉 추상화에만 의존. 구체적 의존은 앱컨피그에서
    //생성자주입
    private final MemberRepository memberRepository;

    public MemberServiceImple(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(long MemberId) {
        return memberRepository.findById(MemberId);
    }
}
