package me.scpark.springdeveloper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // hello 示例
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "반갑습니다, " + name + "님!";
    }

    // RequestParam 示例
    @GetMapping("/student")
    public Student getStudent(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {

        return new Student(firstName, lastName);
    }

    // PathVariable 示例
    @GetMapping("/student/{firstName}/{lastName}")
    public Student getStudent2(
            @PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName) {

        return new Student(firstName, lastName);
    }
}