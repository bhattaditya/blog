package github.bhattaditya.blog.controller;

import github.bhattaditya.blog.dto.requestDto.PostRequestDto;
import github.bhattaditya.blog.dto.responseDto.ApiResponse;
import github.bhattaditya.blog.dto.responseDto.PostResponseDto;
import github.bhattaditya.blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostService postService;

    @PostMapping(value = "/addPost/user/{userId}/category/{categoryId}")
    public ResponseEntity<PostResponseDto> createPost(
            @PathVariable String userId,
            @PathVariable String categoryId,
            @Valid @RequestBody PostRequestDto postRequestDto) {

        LOGGER.info("Post controller calling Post Service class...");
        PostResponseDto postResponseDto = postService.addPost(postRequestDto, userId, categoryId);

        return new ResponseEntity<>(postResponseDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<PostResponseDto>> getPosts() {
        LOGGER.info("Post controller calling Post Service class...");
        List<PostResponseDto> postResponseDtos = postService.getPosts();

        return new ResponseEntity<>(postResponseDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{postId}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable String postId) {
        LOGGER.info("Post controller calling Post Service class...");
        PostResponseDto postResponseDto = postService.getPostById(postId);

        return new ResponseEntity<>(postResponseDto, HttpStatus.OK);
    }

    @GetMapping(value = "/get/category/{categoryId}")
    public ResponseEntity<List<PostResponseDto>> getPostsByCategory(@PathVariable String categoryId) {
        LOGGER.info("Post controller calling Post Service class...");
        List<PostResponseDto> postResponseDtos = postService.postByCategory(categoryId);

        return new ResponseEntity<>(postResponseDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/get/user/{userId}")
    public ResponseEntity<List<PostResponseDto>> getPostsByUser(@PathVariable String userId) {
        LOGGER.info("Post controller calling Post Service class...");
        List<PostResponseDto> postResponseDtos = postService.postsByUser(userId);

        return new ResponseEntity<>(postResponseDtos, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{postId}")
    public ResponseEntity<PostResponseDto> updatePost(
            @PathVariable String postId,
            @RequestBody PostRequestDto postRequestDto) {
        LOGGER.info("Post controller calling Post Service class...");
        PostResponseDto postResponseDto = postService.updatePost(postId, postRequestDto);

        return new ResponseEntity<>(postResponseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove/{postId}")
    public ApiResponse deletePost (@PathVariable String postId) {
        LOGGER.info("Post controller calling Post Service class...");
        postService.deletePost(postId);

        return new ApiResponse("Post Deleted Successfully", true);
    }


}
