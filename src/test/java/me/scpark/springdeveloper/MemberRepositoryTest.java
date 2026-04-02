package me.scpark.springdeveloper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;


    @Test
    @Sql("/insert-members.sql")
    void getAllMembers() {
        //given(준비)


        //when(실행)
        List<Member> members=memberRepository.findAll(); //select * from
//        Member member=memberRepository.findById(2L).get();

        //then(검증)
        assertThat(members.size()).isEqualTo(3);
//        assertThat(member.getName()).isEqualTo("B");
    }

    @Test
    @Sql("/insert-members.sql")
    void getMemberById() {
        Member member=memberRepository.findById(2L).get();
        assertThat(member.getName()).isEqualTo("B");
    }

    @Test
    @Sql("/insert-members.sql")
    void getMemberByName() {
        // when
        Member member = memberRepository.findByName("C").get();

        // then
        assertThat(member.getId()).isEqualTo(3);
    }

    @DisplayName("레코드 삽입 테스트")
    @Test
//    @DirtiesContext
    void saveMember() {
        Member m = new Member("scpark");
        Member savedMember = memberRepository.save(m);

        assertThat(savedMember.getId()).isNotNull();

        Long id = savedMember.getId();
        Optional<Member> result= memberRepository.findById(id);
        Member member=result.get();
        String name=member.getName();
        assertThat(name).isEqualTo("scpark");
//        assertThat(memberRepository.findById(savedMember.getId()).get().getName()).isEqualTo("scpark");
    }

    @DisplayName("2게의 레코드를 한 번에 삽입하는 테스트")
    @Test
//    @DirtiesContext
    void saveMembers() {
        List<Member> members = List.of(new Member("HongGilDong"),new Member("Park MunSu"));
        memberRepository.saveAll(members);
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }

    @Sql("/insert-members.sql")
    @DisplayName("레코드 삭제 테스트")
    @Test
    void deleteAll(){
        memberRepository.deleteAll();
        assertThat(memberRepository.findAll().size()).isZero();
    }

    @Sql("/insert-members.sql")
    @DisplayName("Update Test")
    @Test
    void update(){
        Member member=memberRepository.findById(2L).get();
        member.changeName("scpark");
        assertThat((memberRepository.findById(2L).get().getName())).isEqualTo("scpark");
    }

}
