package castberry.hellospring;

import castberry.hellospring.repository.MemberRepository;
import castberry.hellospring.repository.MemoryMemberRepository;
import castberry.hellospring.sevice.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 만약 회원서비스와 회원레포지토리의 @Service, @Repository, @Autowired 애노테이션이 없다면
// 이처럼 해야함

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
