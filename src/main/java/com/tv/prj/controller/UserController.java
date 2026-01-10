package com.tv.prj.controller;

import com.tv.prj.dto.response.ApiResponse;
import com.tv.prj.dto.UserCreationRequest;
import com.tv.prj.dto.UserUpdateRequest;
import com.tv.prj.entity.User;
import com.tv.prj.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createRequest(request));
        return apiResponse;
    }

    @GetMapping("/list")
     public ApiResponse<List<User>> getListUsers() {
        return ApiResponse.<List<User>>builder().result(userService.getUsers()).build();
    }

    @GetMapping("/detail/{id}")
    ApiResponse<User> getDetailUser(@PathVariable("id") String id) {
        return ApiResponse.<User>builder().result(userService.getUser(id)).build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<User> updateUser(@RequestBody UserUpdateRequest request, @PathVariable("id") String id) {
        return ApiResponse.<User>builder().result(userService.updateUser(id, request)).build();
    }

    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }


}
