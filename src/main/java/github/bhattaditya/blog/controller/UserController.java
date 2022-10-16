package github.bhattaditya.blog.controller;

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
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/addUser")
    public ResponseEntity<UserResponseDto> addUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        LOGGER.info("User controller calling User Service class...");
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/get/{userId}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String userId) {
        LOGGER.info("User controller calling User Service class...");
        UserResponseDto userResponseDto = userService.getUserById(userId);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        LOGGER.info("User controller calling User Service class...");
        List<UserResponseDto> userResponseDtos = userService.getUsers();
        return new ResponseEntity<>(userResponseDtos, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable String userId, @RequestBody UserRequestDto userRequestDto) {
        LOGGER.info("User controller calling User Service class...");
        UserResponseDto userResponseDto = userService.updateUser(userId, userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/remove/{userId}")
    public ApiResponse deleteUser(@PathVariable String userId) {
        LOGGER.info("User controller calling User Service class...");
        userService.deleteUser(userId);
        return new ApiResponse("User deleted Successfully", true);
    }
}
