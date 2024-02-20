package org.spring.blog.dto;

import org.spring.blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddArticleRequest {
    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return Article.builder()
                .id(id)
                .title(title)
                .content(content)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
