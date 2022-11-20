package github.bhattaditya.blog.controller;

import github.bhattaditya.blog.constants.BlogApiConstants;
import github.bhattaditya.blog.constants.BlogConstants;
import github.bhattaditya.blog.dto.requestDto.CommentRequestDto;
import github.bhattaditya.blog.dto.responseDto.ApiResponse;
import github.bhattaditya.blog.dto.responseDto.CommentResponseDto;
import github.bhattaditya.blog.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = BlogConstants.BLOG_COMMENT)
public class CommentController {

    @Autowired
    private CommentService commentService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @PostMapping(value = BlogApiConstants.CREATE_COMMENT)
    public ResponseEntity<CommentResponseDto> addComment(@PathVariable String userId, @PathVariable String postId, @RequestBody CommentRequestDto commentRequestDto) {
        LOGGER.info("Comment controller calling Comment Service class...");
        CommentResponseDto commentResponseDto = commentService.addComment(userId, postId ,commentRequestDto);
        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = BlogApiConstants.REMOVE_COMMENT)
    public ResponseEntity<ApiResponse> removeComment(@PathVariable String commentId) {
        LOGGER.info("Comment controller calling Comment Service class...");
        commentService.removeComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully", true), HttpStatus.OK);
    }
}
