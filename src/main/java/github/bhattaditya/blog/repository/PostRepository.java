package github.bhattaditya.blog.repository;

import github.bhattaditya.blog.model.Category;
import github.bhattaditya.blog.model.Post;
import github.bhattaditya.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
