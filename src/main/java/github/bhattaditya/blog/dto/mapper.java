package github.bhattaditya.blog.dto;

import github.bhattaditya.blog.dto.responseDto.CategoryResponseDto;
import github.bhattaditya.blog.dto.responseDto.PostResponseDto;
import github.bhattaditya.blog.dto.responseDto.UserResponseDto;
import github.bhattaditya.blog.model.Category;
import github.bhattaditya.blog.model.Post;
import github.bhattaditya.blog.model.User;

import java.util.ArrayList;
import java.util.List;

public class mapper {

    public static UserResponseDto userToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
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

    public static CategoryResponseDto categoryToCategoryResponse(Category category) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setTitle(category.getTitle());
        categoryResponseDto.setDescription(category.getDescription());

        return categoryResponseDto;
    }

    public static List<CategoryResponseDto> categoryToCategoryResponseDtos(List<Category> categories) {

        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for (Category category: categories) {
            categoryResponseDtos.add(categoryToCategoryResponse(category));
        }

        return categoryResponseDtos;
    }

    public static PostResponseDto postToPostResponseDto(Post post) {
        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(post.getId());
        postResponseDto.setTitle(post.getTitle());
        postResponseDto.setContent(post.getContent());
        postResponseDto.setUser(userToUserResponseDto(post.getUser()));
        postResponseDto.setCategory(categoryToCategoryResponse(post.getCategory()));

        return postResponseDto;
    }

    public static List<PostResponseDto> postToPostResponseDtos(List<Post> posts) {
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for(Post post: posts) {
            postResponseDtos.add(postToPostResponseDto(post));
        }

        return postResponseDtos;
    }
}
