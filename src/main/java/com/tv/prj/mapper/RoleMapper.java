package com.tv.prj.mapper;

import com.tv.prj.dto.RoleRequest;
import com.tv.prj.dto.response.RoleResponse;
import com.tv.prj.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest roleRequest);
    RoleResponse toRoleResponse(Role role);
}
