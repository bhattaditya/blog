package github.bhattaditya.blog.controller;

import github.bhattaditya.blog.constants.BlogApiConstants;
import github.bhattaditya.blog.constants.BlogConstants;
import github.bhattaditya.blog.dto.requestDto.UserRequestDto;
import github.bhattaditya.blog.dto.responseDto.ApiResponse;
import github.bhattaditya.blog.dto.responseDto.UserResponseDto;
import github.bhattaditya.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = BlogConstants.BLOG_USER)
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = BlogApiConstants.CREATE_USER)
    public ResponseEntity<UserResponseDto> addUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        LOGGER.info("User controller calling User Service class...");
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping(value = BlogApiConstants.USER)
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String userId) {
        LOGGER.info("User controller calling User Service class...");
        UserResponseDto userResponseDto = userService.getUserById(userId);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @GetMapping(value = BlogApiConstants.USERS)
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        LOGGER.info("User controller calling User Service class...");
        List<UserResponseDto> userResponseDtos = userService.getUsers();
        return new ResponseEntity<>(userResponseDtos, HttpStatus.OK);
    }

    @PutMapping(value = BlogApiConstants.UPDATE_USER)
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable String userId, @RequestBody UserRequestDto userRequestDto) {
        LOGGER.info("User controller calling User Service class...");
        UserResponseDto userResponseDto = userService.updateUser(userId, userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = BlogApiConstants.REMOVE_USER)
    public ApiResponse deleteUser(@PathVariable String userId) {
        LOGGER.info("User controller calling User Service class...");
        userService.deleteUser(userId);
        return new ApiResponse("User deleted Successfully", true);
    }
}
