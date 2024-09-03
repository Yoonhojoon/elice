
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

    // 수정
    Post save(Post post);
    
    // 삭제
    void delete(Post post);

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

    public Post savePost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        return postRepository.save(post);
    }

    public Post savePost(PostDTO postDTO) {
        return postRepository.save(postDTO.toEntity());
    }

    // 1. 게시글을 수정하는 기능
    public Post updatePost(PostDTO postDTO) {
        
        Post post = postRepository.findById(postDTO.getId()).orElse(null);
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        return post;
    }


    // 2. 게시글을 삭제하는 기능
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        postRepository.delete(post);
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

    // PUT APIs
    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        postDTO.setId(id);
        return postService.updatePost(postDTO);
    }


    // DELETE APIs
    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable(value = "id") Long id) {
        postService.deletePost(id);
    }
}

```
