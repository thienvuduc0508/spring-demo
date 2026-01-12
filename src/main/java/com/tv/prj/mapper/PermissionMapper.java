package com.tv.prj.mapper;
import org.mapstruct.Mapper;

import com.tv.prj.dto.PermissionRequest;
import com.tv.prj.dto.response.PermissionResponse;
import com.tv.prj.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest permissionRequest);
    PermissionResponse toPermissionResponse(Permission permission);
}
