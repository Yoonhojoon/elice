
PostRepository.java
```java
package com.elice.post.repository;

import com.elice.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // 전체 리스트 조회
    List<Post> findAll();


    // id 조건 조회
    Optional<Post> findById(Long id);
}

```



PostService.java
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

    // 2-1 전체 리스트 조회 서비스
    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    // 2-2 id 기반 조회 서비스
    public Post getPostById(Long id) {
        return this.postRepository.findById(id).orElse(null);        

    }

}

```



PostController.java
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

    // GET API
    // 게시글 전체를 조회하는 기능
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    // url에서 id 값을 이용하여 게시글 하나를 조회하는 기능
    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable(value = "id") Long id) {
        return postService.getPostById(id);
    }

}

```


