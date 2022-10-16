package github.bhattaditya.blog.dto.responseDto;

import github.bhattaditya.blog.model.Category;
import github.bhattaditya.blog.model.User;
import lombok.Data;

@Data
public class PostResponseDto {
    private long id;
    private String title;
    private String content;
    private String imageURL;
    private CategoryResponseDto category;
    private UserResponseDto user;
}
