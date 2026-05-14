package me.scpark.springdeveloper.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.scpark.springdeveloper.dao.Article;
import me.scpark.springdeveloper.dto.ArticleResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExampleController {
    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model){
        List<ArticleResponse> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            ArticleResponse a=new ArticleResponse(new Article("제목"+(i+1),(i+1)+"번째 내용"));
            list.add(a);
        }
        model.addAttribute("articles", list);
        model.addAttribute("name","性感红唇大蟑螂");
//        model.addAttribute("error","검색 오류발생");
        Person p=new Person(1L,"哈基米",18,List.of("运动","读书","看电影","听音乐","摄影"));
        model.addAttribute("person",p);
        return "example";
    }

}

@Setter
@Getter
@AllArgsConstructor
class Person{
    private Long id;
    private String name;
    private int age;
    private List<String> hobbies;
}
