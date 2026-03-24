package me.scpark.springdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestRepository memberRespository;
    public List<Member> getAllMembers(){
        return memberRespository.findAll();
    }

    public Member saveMember(Member member){
        return memberRespository.save(member);
    }
}
