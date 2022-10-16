package github.bhattaditya.blog.dto.requestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class PostRequestDto {
    @NotEmpty
    @Size(max = 100, message = "title be empty")
    private String title;

    @NotEmpty
    @Size(max = 5000, message = "content should be there")
    private String content;

    private String imageURL;
}
