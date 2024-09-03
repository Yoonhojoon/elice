
Respository.java
```java

// 지시사항에 따라 코드를 작성해 주세요.
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findAll();
}
```
