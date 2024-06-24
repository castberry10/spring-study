package castberry.hellospring;

import castberry.hellospring.repository.JdbcMemberRepository;
import castberry.hellospring.repository.JdbcTemplateMemberRepository;
import castberry.hellospring.repository.JpaMemberRepository;
import castberry.hellospring.repository.MemberRepository;
import castberry.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.swing.*;
// 만약 회원서비스와 회원레포지토리의 @Service, @Repository, @Autowired 애노테이션이 없다면
// 이처럼 해야함

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
//    private DataSource dataSource;
//
//    private EntityManager em;

//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }
    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
//        return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
