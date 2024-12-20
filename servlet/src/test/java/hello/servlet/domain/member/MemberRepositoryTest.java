package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void saveMember() throws Exception {
        //given
        Member member = new Member("kim", 20);
        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
        assertThat(savedMember.getId()).isEqualTo(findMember.getId());
        assertThat(savedMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(savedMember.getAge()).isEqualTo(member.getAge());
     }

     @Test
     void findAll() throws Exception {
         //given
         Member member1 = new Member("member1", 20);
         Member member2 = new Member("member2", 20);

         memberRepository.save(member1);
         memberRepository.save(member2);
         //when

         List<Member> result = memberRepository.findAll();

         //then

         assertThat(result.size()).isEqualTo(2);
         assertThat(result).contains(member1, member2);
      }



}