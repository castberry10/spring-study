package castberry.hellospring.service;

import castberry.hellospring.domain.Member;
import castberry.hellospring.repository.MemberRepository;
import castberry.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest
// - 스프링 컨테이너와 테스트를 함께 실행
// @트랜젝션
// - 테스트 케이스에 있으면 테스트 시작전에 트랜젝션을 시작하고 테스트 완료 후에 롤백한다
// - 연속적인 테스트가 가능하다 <- Test에서만 이럼 서비스에서는 커밋됨
// 롤백을 원치않으면 테스트케이스에 @Commit을 작성해도 된다
@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
//    @Autowired MemberRepository memberRepository;


    // 디비를 지우고 해야함
    // -> 그래서 보통 테스트 디비를 따로 만든다
    @Test
    void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then

    }

}