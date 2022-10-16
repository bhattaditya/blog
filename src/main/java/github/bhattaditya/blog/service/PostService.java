package github.bhattaditya.blog.service;

import github.bhattaditya.blog.dto.mapper;
import github.bhattaditya.blog.dto.requestDto.PostRequestDto;
import github.bhattaditya.blog.dto.responseDto.PostResponseDto;
import github.bhattaditya.blog.exception.ResourceNotFoundException;
import github.bhattaditya.blog.model.Category;
import github.bhattaditya.blog.model.Post;
import github.bhattaditya.blog.model.User;
import github.bhattaditya.blog.repository.CategoryRepository;
import github.bhattaditya.blog.repository.PostRepository;
import github.bhattaditya.blog.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public PostResponseDto addPost(PostRequestDto postRequestDto, String userId, String categoryId) {
        LOGGER.info("In Post Service class... inserting post");
        User user = userRepository.findById(Long.parseLong(userId))
                .orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));

        Category category = categoryRepository.findById(Long.parseLong(categoryId))
                .orElseThrow(() -> new ResourceNotFoundException("Category", "ID", categoryId));

        Post post = new Post();
        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());
        post.setUser(user);
        post.setCategory(category);
        post.setImageURL(postRequestDto.getImageURL());
        postRepository.save(post);
        LOGGER.info("Post Saved");

        return mapper.postToPostResponseDto(post);
    }

    public List<PostResponseDto> getPosts() {
        LOGGER.info("In Post Service class... fetching all posts");
        List<Post> posts = postRepository.findAll();

        return mapper.postToPostResponseDtos(posts);
    }

    public PostResponseDto getPostById(String postId) {
        LOGGER.info("In Post Service class... fetching post");
        Post post = getPost(postId);

        return mapper.postToPostResponseDto(post);
    }

    public Post getPost(String postId) {
        Post post = postRepository.findById(Long.valueOf(postId))
                .orElseThrow(()-> new ResourceNotFoundException("Post", "ID", postId));

        return post;
    }

    @Transactional
    public PostResponseDto updatePost(String postId, PostRequestDto postRequestDto) {
        LOGGER.info("In Post Service class... updating post");
        Post post = getPost(postId);
        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());
        post.setImageURL(postRequestDto.getImageURL());
        LOGGER.info("Post Updated!");

        return mapper.postToPostResponseDto(post);
    }

    public void deletePost(String postId) {
        LOGGER.info("In Post Service class... deleting post");
        Post post = getPost(postId);
        LOGGER.info("Post deleted");
        postRepository.delete(post);
    }

    public List<PostResponseDto> postsByUser(String userId){
        LOGGER.info("In Post Service class... fetching all posts of user having ID: " + userId);
        User user = userRepository.findById(Long.valueOf(userId))
                .orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));
        List<Post> posts = postRepository.findByUser(user);

        return mapper.postToPostResponseDtos(posts);
    }

    public List<PostResponseDto> postByCategory(String categoryId) {
        LOGGER.info("In Post Service class... fetching all posts by category having ID: " + categoryId);
        Category category = categoryRepository.findById(Long.valueOf(categoryId))
                .orElseThrow(() -> new ResourceNotFoundException("Category", "ID", categoryId));

        List<Post> posts = postRepository.findByCategory(category);

        return mapper.postToPostResponseDtos(posts);
    }


}
