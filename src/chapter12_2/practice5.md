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
	@DisplayName("블로그 글 업데이트 테스트")
	void updateArticleTest() {
	    // Given
	    Long articleId = 1L;
	    Article existingArticle = new Article("Old Title", "Old Content");
	    UpdateArticleRequest updateRequest = new UpdateArticleRequest("New Title", "New Content");

	    when(blogRepository.findById(articleId)).thenReturn(Optional.of(existingArticle));

	    // When
	    Article updatedArticle = blogService.update(articleId, updateRequest);

	    // Then
	    assertNotNull(updatedArticle);
	    assertEquals("New Title", updatedArticle.getTitle());
	    assertEquals("New Content", updatedArticle.getContent());
	    verify(blogRepository, times(1)).findById(articleId);
	}
    
}
```
