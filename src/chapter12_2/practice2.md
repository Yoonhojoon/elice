BlogServiceTest
```java
package com.elice.service;

import com.elice.domain.Article;
import com.elice.dto.AddArticleRequest;
import com.elice.dto.UpdateArticleRequest;
import com.elice.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BlogServiceTest {

    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogService blogService;

    @BeforeEach void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @Test
    @DisplayName("블로그 전체 글 조회 테스트")
    void findAllArticlesTest() {
    
        // Given
        List<Article> articles = Arrays.asList(
                new Article("Title 1", "Content 1"),
                new Article("Title 2", "Content 2")
        );
        when(blogRepository.findAll()).thenReturn(articles);

        // When
        List<Article> foundArticles = blogService.findAll();

        // Then
        assertNotNull(foundArticles);
        assertEquals(2, foundArticles.size());
        assertEquals("Title 1", foundArticles.get(0).getTitle());
        assertEquals("Title 2", foundArticles.get(1).getTitle());
        verify(blogRepository, times(1)).findAll();
    }
    
}
```
