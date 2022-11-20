package github.bhattaditya.blog.dto.responseDto;

import lombok.Data;

@Data
public class CommentResponseDto {

    private Long id;
    private String content;
    private UserResponseDto user;
}
