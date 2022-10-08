package github.bhattaditya.blog.dto.requestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CategoryRequestDto {

    @NotEmpty
    @Size(min = 4, max = 50, message = "Title should have at least 4 characters and 50 characters are maximum")
    private String title;

    @NotEmpty
    @Size(min = 10, message = "Description should be at least characters 10 characters")
    private String description;
}
