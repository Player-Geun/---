package geun.springcoreprinciple.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepositroy memberRepositroy;

    public MemberServiceImpl(MemberRepositroy memberRepository) {

        this.memberRepositroy = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepositroy.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepositroy.findById(memberId);
    }
}
