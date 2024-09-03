
PostRepository
```java
package com.elice.post.repository;

import com.elice.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();

    Optional<Post> findById(Long id);

    List<Post> findByTitleContainingOrContentContaining(String title, String content);

    // 입력
    Post save(Post post);
}

```



PostService
```java
package com.elice.post.service;

import com.elice.post.domain.Post;
import com.elice.post.dto.PostDTO;
import com.elice.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> getPostsByTitleContainingOrContentContaining(String title, String content) {
        return postRepository.findByTitleContainingOrContentContaining(title, content);
    }

    // 2-a 입력방법 1
    public Post savePost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);        
        return postRepository.save(post);
    }

    // 2-b 입력방법 2: DTO를 활용하는 방법
    public Post savePost(PostDTO postDTO) {        
        return postRepository.save(postDTO.toEntity());
    }
}

```



PostController
```java
package com.elice.post.controller;

import com.elice.post.domain.Post;
import com.elice.post.dto.PostDTO;
import com.elice.post.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // POST APIs
    // 게시글을 생성하는 기능
    // Post를 통해 전달받는 파라미터를 범용적으로 사용하기 위해서 Map을 사용
    @PostMapping("/posts/new")
    public Post createPost(@RequestBody Map<String, String> param) {
        String title = param.get("title");
        String content = param.get("contents");

        return postService.savePost(title, content);
    }

    // 게시글을 생성하는 기능
    // PostDTO를 통해 전달받는 파라미터를 사용
    @PostMapping("/posts")
    public Post createPost(@RequestBody PostDTO postDTO) {
        return postService.savePost(postDTO);
    }

}

```



PostDTO
```java
package com.elice.post.dto;

import com.elice.post.domain.Post;

public class PostDTO {

    private Long id;
    private String title;
    private String content;

    public PostDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Post toEntity() {
        return new Post(title, content);
    }
}

```