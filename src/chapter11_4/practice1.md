
PostRepository
```java
package com.elice.post.repository;

import com.elice.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();

    Optional<Post> findById(Long id);

    Post save(Post post);

    void delete(Post post);
    
    // 조회 메서드를 생성합니다.
    List<Post> findByTitleContaining(String keyword);
}
```



PostService
```java
package com.elice.post.service;

import com.elice.post.domain.Post;
import com.elice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    // 데이터베이스에 접근하기 위한 객체입니다.
    @Autowired
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    
    // searchPosts 메서드를 작성합니다.
    public List<Post> searchPosts(String keyword) {
        return postRepository.findByTitleContaining(keyword);
    }
}
```



PostController
```java
package com.elice.post.controller;

import com.elice.post.domain.Post;
import com.elice.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "home";
    }

    @GetMapping("/search/{keyword}")
    public String getSearchedPosts(@PathVariable(value = "keyword") String keyword, Model model) {
        model.addAttribute("posts", postService.searchPosts(keyword));
        return "home";
    }
}

```

