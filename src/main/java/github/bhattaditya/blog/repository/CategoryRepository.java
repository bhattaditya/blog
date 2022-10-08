package github.bhattaditya.blog.repository;

import github.bhattaditya.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
