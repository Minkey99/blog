package org.spring.blog.controller;

import lombok.RequiredArgsConstructor;
import org.spring.blog.domain.Article;
import org.spring.blog.dto.AddArticleRequest;
import org.spring.blog.dto.ArticleResponse;
import org.spring.blog.dto.UpdateArticleRequest;
import org.spring.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(
            @RequestBody AddArticleRequest addArticleRequest
    ) {
        Article savedArticle = blogService.save(addArticleRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> article = blogService.findAllArticle()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(article);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(
            @PathVariable Long id
    ) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(
            @PathVariable Long id,
            @RequestBody UpdateArticleRequest request
            ) {
        Article article = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(article);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> deleteArticle(
            @PathVariable Long id
    ) {
        blogService.deleteArticle(id);

        return ResponseEntity.ok()
                .build();
    }
}
