package org.spring.blog.controller;

import lombok.RequiredArgsConstructor;
import org.spring.blog.domain.Article;
import org.spring.blog.dto.AddArticleRequest;
import org.spring.blog.dto.ArticleListViewResponse;
import org.spring.blog.dto.ArticleViewResponse;
import org.spring.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogViewController {

    private final BlogService blogService;

    @PostMapping("/articles")
    public String addArticle(
            AddArticleRequest addArticleRequest
    ) {
        blogService.savePost(addArticleRequest);

        return "redirect:/";
    }

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAllArticle().stream()
                .map(ArticleListViewResponse::new)
                .toList();

        model.addAttribute("articles", articles);

        return "board/articleList.html";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article =  blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "board/article.html";
    }

    @GetMapping("/new-article")
    public String newArticle(
            @RequestParam(required = false) Long id, Model model
    ) {
        if(id == null) {
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "board/newArticle.html";
    }
}
