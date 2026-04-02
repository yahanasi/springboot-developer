package me.scpark.springdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository  extends JpaRepository<Member,Long> {
    //asve(), findById(id), findAll(),deleteById(id)...
    public Optional<Member> findByName(String name);
}
