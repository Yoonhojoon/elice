
Image
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
@Table(name = "IMAGE")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="image_id")
    private Long id;

    private String imgUrl;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    // TODO: 코드 입력
    // Image N : Post 1
    // FK : post_id
    // 주인(owner) : Image
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    public Image(String imgUrl, Post post) {
        this.imgUrl = imgUrl;
        this.post = post;
        
    }

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
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private Long id;

    private String title;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    
    // TODO: 1. Post 클래스에 Image 리스트 객체를 참조하는 필드를 추가하세요.   
    @OneToMany(mappedBy = "post")
    private List<Image> imgList = new ArrayList<>();
    
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

```




```java

```




```java

```