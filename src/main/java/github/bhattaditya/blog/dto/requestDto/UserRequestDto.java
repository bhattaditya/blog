package github.bhattaditya.blog.dto.requestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequestDto {
    private String name;
    private String password;
    private String email;
}
