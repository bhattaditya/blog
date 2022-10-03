package github.bhattaditya.blog.dto.requestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class UserRequestDto {
    @NotEmpty
    @Size(min = 4, max = 8, message = "Name should have at least 4 characters and 8 characters are maximum")
    private String name;

    @NotBlank
    @Size(min = 4, max = 16, message = "Password should have at least 4 characters and 16 characters are maximum")
    private String password;

    @Email(message = "Not a valid email address")
    private String email;
}
