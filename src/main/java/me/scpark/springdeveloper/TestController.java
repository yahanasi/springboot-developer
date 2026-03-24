package me.scpark.springdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/test")
//    @ResponseBody
    public ResponseEntity<List<Member>> getAllMembers() {

        return ResponseEntity.ok( testService.getAllMembers());
    }
    @GetMapping("/test2")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/test")
    public ResponseEntity<Member> createMember(@RequestBody Member member){
        return ResponseEntity.ok(testService.saveMember(member));
    }
}