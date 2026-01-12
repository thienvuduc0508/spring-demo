package com.tv.prj.controller;

import com.tv.prj.dto.RoleRequest;
import com.tv.prj.dto.response.ApiResponse;
import com.tv.prj.dto.response.RoleResponse;
import com.tv.prj.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/create")
    public ApiResponse<RoleResponse> create(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder().result(roleService.create(request)).build();
    }

    @GetMapping
    public ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder().result(roleService.getAll()).build();
    }

    @DeleteMapping("/delete/{roleName}")
    public void delete(@PathVariable String roleName) {
         roleService.deleteRole(roleName);
    }

}
