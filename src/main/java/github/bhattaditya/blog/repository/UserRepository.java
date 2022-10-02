package github.bhattaditya.blog.repository;

import github.bhattaditya.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}