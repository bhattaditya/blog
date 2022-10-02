package github.bhattaditya.blog.service;

import github.bhattaditya.blog.dto.mapper;
import github.bhattaditya.blog.dto.requestDto.UserRequestDto;
import github.bhattaditya.blog.dto.responseDto.UserResponseDto;
import github.bhattaditya.blog.model.User;
import github.bhattaditya.blog.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        LOGGER.info("In User Service class... creating user");
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setPassword(userRequestDto.getPassword());
        user.setEmail(userRequestDto.getEmail());

        userRepository.save(user);
        LOGGER.info("User created successfully!");
        return mapper.userToUserResponseDto(user);
    }

    @Transactional
    public UserResponseDto updateUser(String userId, UserRequestDto userRequestDto) {
        LOGGER.info("In User Service class... updating user");
        User editUser = getUser(userId);
        editUser.setName(userRequestDto.getName());
        editUser.setPassword(userRequestDto.getPassword());
        editUser.setEmail(userRequestDto.getEmail());
        LOGGER.info("User details updated successfully!");

        return mapper.userToUserResponseDto(editUser);
    }

    public List<UserResponseDto> getUsers() {
        LOGGER.info("In User Service class... fetching all users");
        List<User> users = userRepository.findAll();
        return mapper.userToUserResponseDtos(users);
    }

    public UserResponseDto getUserById(String userId) {
        LOGGER.info("In User Service class... fetching user");
        User user = getUser(userId);
        return mapper.userToUserResponseDto(user);
    }

    public User getUser(String userId) {

        return userRepository.findById(Long.parseLong(userId))
                .orElseThrow(()-> new IllegalStateException("User with ID: " + userId + " not found"));
    }

    public void deleteUser(String userId) {
        LOGGER.info("In User Service class... deleting user");
        User user = getUser(userId);
        userRepository.delete(user);
        LOGGER.info("User deleted successfully!");
    }
}
