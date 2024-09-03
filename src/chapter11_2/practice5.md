
Comment
```java
package com.elice.post.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COMMENT_ID")
    private Long id;

    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    // TODO: 코드 입력
    // 댓글 N : 게시글 1
    // FK : post_id
    // 주인(owner) : 댓글


    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}

```



Post
```java
package com.elice.post.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.ArrayList;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POST_ID")
    private Long id;

    private String title;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    
    // TODO: 1. Post 클래스에 Comment 객체를 참조하는 필드를 추가하세요.   

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @OneToMany(mappedBy = "post")
    private List<Comment> commentList = new ArrayList<>();
}

```

