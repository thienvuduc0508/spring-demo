package com.tv.prj.controller;

import com.tv.prj.dto.PermissionRequest;
import com.tv.prj.dto.response.ApiResponse;
import com.tv.prj.dto.response.PermissionResponse;
import com.tv.prj.services.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("permissions")
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping("/create")
    public ApiResponse<PermissionResponse> create(@RequestBody PermissionRequest request){
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.create(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<PermissionResponse>> getAll() {
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.getAll())
                .build();
    }
}
