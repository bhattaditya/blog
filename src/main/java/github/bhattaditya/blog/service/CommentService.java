package github.bhattaditya.blog.service;

import github.bhattaditya.blog.dto.mapper;
import github.bhattaditya.blog.dto.requestDto.CommentRequestDto;
import github.bhattaditya.blog.dto.responseDto.CommentResponseDto;
import github.bhattaditya.blog.exception.ResourceNotFoundException;
import github.bhattaditya.blog.model.Comment;
import github.bhattaditya.blog.model.Post;
import github.bhattaditya.blog.model.User;
import github.bhattaditya.blog.repository.CommentRepository;
import github.bhattaditya.blog.repository.PostRepository;
import github.bhattaditya.blog.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public CommentResponseDto addComment(String userId, String postId, CommentRequestDto commentRequestDto) {
        LOGGER.info("In Comment Service class... inserting comment");
        User user = userRepository.findById(Long.valueOf(userId))
                .orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));

        Post post = postRepository.findById(Long.valueOf(postId))
                .orElseThrow(()-> new ResourceNotFoundException("Post", "ID", postId));

        Comment comment = new Comment();
        comment.setContent(commentRequestDto.getContent());
        comment.setPost(post);
        comment.setUser(user);
        comment.setCreatedDate(LocalDateTime.now());
        commentRepository.save(comment);

        LOGGER.info("comment saved...");
        return mapper.commentToCommentResponseDto(comment);
    }

    public void removeComment(String commentId) {
        LOGGER.info("In Comment Service class... deleting comment");
        Comment comment = commentRepository
                .findById(Long.valueOf(commentId)).orElseThrow(()-> new ResourceNotFoundException("Comment", "ID", commentId));

        commentRepository.delete(comment);
        LOGGER.info("comment deleted");
    }
}
