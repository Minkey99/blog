package org.spring.blog.dto;

import lombok.Getter;
import lombok.extern.java.Log;
import org.spring.blog.domain.Article;



@Getter
public class ArticleResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
