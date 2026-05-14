package me.scpark.springdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.scpark.springdeveloper.dao.Article;
import me.scpark.springdeveloper.dto.ArticleResponse;
import me.scpark.springdeveloper.dto.ArticleViewResponse;
import me.scpark.springdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class BlogViewController {
    //    @Autowired
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleResponse> articles =
                blogService.findAll().stream().map(ArticleResponse::new).toList();
        model.addAttribute("articles",articles);
        return "articlesList";
    }
    @GetMapping("new-article")
    public String newArticle(@RequestParam(required = false) Long id,Model model){
        if(id != null){
            Article article = blogService.findById(id);
            model.addAttribute("article",new ArticleViewResponse(article));
        }else{
            model.addAttribute("article",new ArticleViewResponse());
        }
        return "newArticle";
    }
}