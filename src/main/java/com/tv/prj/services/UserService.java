package com.tv.prj.services;

import com.tv.prj.dto.UserCreationRequest;
import com.tv.prj.dto.UserUpdateRequest;
import com.tv.prj.entity.User;
import com.tv.prj.exception.AppException;
import com.tv.prj.exception.ErrorCode;
import com.tv.prj.mapper.UserMapper;
import com.tv.prj.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
     UserRepository userRepository;
     UserMapper userMapper;

    public User createRequest(UserCreationRequest userRequest) {
        if(userRepository.existsByUserName(userRequest.getUserName())) throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(userRequest);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
    }

    public User updateUser(String id, UserUpdateRequest request) {
        User user = getUser(id);
        userMapper.updateUser(user, request);
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }


}
