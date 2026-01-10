package com.tv.prj.mapper;

import com.tv.prj.dto.UserCreationRequest;
import com.tv.prj.dto.UserUpdateRequest;
import com.tv.prj.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
