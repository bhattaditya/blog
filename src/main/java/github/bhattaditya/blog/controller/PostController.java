package github.bhattaditya.blog.controller;

import github.bhattaditya.blog.constants.BlogApiConstants;
import github.bhattaditya.blog.constants.BlogConstants;
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
@RequestMapping(value = BlogConstants.BLOG_POST)
public class PostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @PostMapping(value = BlogApiConstants.CREATE_POST)
    public ResponseEntity<PostResponseDto> createPost(
            @PathVariable String userId,
            @PathVariable String categoryId,
            @Valid @RequestBody PostRequestDto postRequestDto) {

        LOGGER.info("Post controller calling Post Service class...");
        PostResponseDto postResponseDto = postService.addPost(postRequestDto, userId, categoryId);

        return new ResponseEntity<>(postResponseDto, HttpStatus.CREATED);
    }

    @GetMapping(value = BlogApiConstants.POSTS)
    public ResponseEntity<List<PostResponseDto>> getPosts() {
        LOGGER.info("Post controller calling Post Service class...");
        List<PostResponseDto> postResponseDtos = postService.getPosts();

        return new ResponseEntity<>(postResponseDtos, HttpStatus.OK);
    }

    @GetMapping(value = BlogApiConstants.POST)
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable String postId) {
        LOGGER.info("Post controller calling Post Service class...");
        PostResponseDto postResponseDto = postService.getPostById(postId);

        return new ResponseEntity<>(postResponseDto, HttpStatus.OK);
    }

    @GetMapping(value = BlogApiConstants.POST_CATEGORY)
    public ResponseEntity<List<PostResponseDto>> getPostsByCategory(@PathVariable String categoryId) {
        LOGGER.info("Post controller calling Post Service class...");
        List<PostResponseDto> postResponseDtos = postService.postByCategory(categoryId);

        return new ResponseEntity<>(postResponseDtos, HttpStatus.OK);
    }

    @GetMapping(value = BlogApiConstants.POST_USER)
    public ResponseEntity<List<PostResponseDto>> getPostsByUser(@PathVariable String userId) {
        LOGGER.info("Post controller calling Post Service class...");
        List<PostResponseDto> postResponseDtos = postService.postsByUser(userId);

        return new ResponseEntity<>(postResponseDtos, HttpStatus.OK);
    }

    @PutMapping(value = BlogApiConstants.UPDATE_POST)
    public ResponseEntity<PostResponseDto> updatePost(
            @PathVariable String postId,
            @RequestBody PostRequestDto postRequestDto) {
        LOGGER.info("Post controller calling Post Service class...");
        PostResponseDto postResponseDto = postService.updatePost(postId, postRequestDto);

        return new ResponseEntity<>(postResponseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = BlogApiConstants.REMOVE_POST)
    public ApiResponse deletePost (@PathVariable String postId) {
        LOGGER.info("Post controller calling Post Service class...");
        postService.deletePost(postId);

        return new ApiResponse("Post Deleted Successfully", true);
    }


}
