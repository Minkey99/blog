package org.spring.blog.service;

import jakarta.transaction.Transactional;
import org.spring.blog.domain.Article;
import org.spring.blog.dto.AddArticleRequest;
import lombok.RequiredArgsConstructor;
import org.spring.blog.dto.UpdateArticleRequest;
import org.springframework.stereotype.Service;
import org.spring.blog.repository.BlogRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    final BlogRepository blogRepository;

    public Article save(AddArticleRequest addArticleRequest) {
        return blogRepository.save(addArticleRequest.toEntity());
    }

    @Transactional
    public Long savePost(AddArticleRequest addArticleRequest) {
        return blogRepository.save(addArticleRequest.toEntity()).getId();
    }

    public List<Article> findAllArticle() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() ->  new IllegalArgumentException("not found " + id));
    }

    public void deleteArticle(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
