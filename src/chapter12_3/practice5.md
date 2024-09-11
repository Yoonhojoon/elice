
BlogApiControllerTest
```java
package com.elice.controller;

import com.elice.domain.Article;
import com.elice.dto.AddArticleRequest;
import com.elice.dto.UpdateArticleRequest;
import com.elice.repository.BlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class BlogApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    BlogRepository blogRepository;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        blogRepository.deleteAll();
    }

    // 지시사항을 참고하여 코드를 작성해 보세요.
	@DisplayName("deleteArticle: 블로그 글 삭제 성공 테스트")
	@Test
	public void deleteArticle() throws Exception {
	    // given
	    final String url = "/api/articles/{id}";
	    final String title = "title";
	    final String content = "content";

	    Article savedArticle = blogRepository.save(Article.builder()
	            .title(title)
	            .content(content)
	            .build());

	    // when
	    mockMvc.perform(delete(url, savedArticle.getId()))
	            .andExpect(status().isOk());

	    // then
	    List<Article> articles = blogRepository.findAll();

	    assertThat(articles).isEmpty();
	}

}



```


