
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
    @DisplayName("ID로 블로그 글 조회 테스트")
    void findArticleByIdTest() {
        // Given
        Long articleId = 1L;
        Article article = new Article("Test Title", "Test Content");
        when(blogRepository.findById(articleId)).thenReturn(Optional.of(article));

        // When
        Article foundArticle = blogService.findById(articleId);

        // Then
        assertNotNull(foundArticle);
        assertEquals("Test Title", foundArticle.getTitle());
        assertEquals("Test Content", foundArticle.getContent());
        verify(blogRepository, times(1)).findById(articleId);
    }

    // 예외발생을 강제로 하는 테스트    
    @Test
    @DisplayName("존재하지 않는 ID로 조회 시 예외 발생 테스트")
    void findArticleByNonExistentIdTest() {
        // Given
        Long nonExistentId = 999L;
        when(blogRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            blogService.findById(nonExistentId);
        });
        assertTrue(exception.getMessage().contains("not found : " + nonExistentId));
        verify(blogRepository, times(1)).findById(nonExistentId);
    }




    
}
```

