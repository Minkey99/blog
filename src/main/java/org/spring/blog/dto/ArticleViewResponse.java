package org.spring.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.spring.blog.domain.Article;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ArticleViewResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createAt = article.getCreatedAt();
        this.updateAt = article.getUpdatedAt();
    }
}
