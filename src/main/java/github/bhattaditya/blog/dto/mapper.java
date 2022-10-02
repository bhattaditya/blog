package github.bhattaditya.blog.dto;

import github.bhattaditya.blog.dto.responseDto.UserResponseDto;
import github.bhattaditya.blog.model.User;

import java.util.ArrayList;
import java.util.List;

public class mapper {

    public static UserResponseDto userToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());

        return userResponseDto;
    }

    public static List<UserResponseDto> userToUserResponseDtos(List<User> users) {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for (User user: users) {
            userResponseDtos.add(userToUserResponseDto(user));
        }

        return userResponseDtos;
    }
}
