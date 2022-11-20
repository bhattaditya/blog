package github.bhattaditya.blog.dto.responseDto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostResponseDto {
    private long id;
    private String title;
    private String content;
    private String imageURL;
    private CategoryResponseDto category;
    private UserResponseDto user;
    private List<CommentResponseDto> comments = new ArrayList<>();
}
