package com.tv.prj.services;

import com.tv.prj.dto.RoleRequest;
import com.tv.prj.dto.response.RoleResponse;
import com.tv.prj.mapper.PermissionMapper;
import com.tv.prj.mapper.RoleMapper;
import com.tv.prj.repository.PermissionRepository;
import com.tv.prj.repository.RoleRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor

public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final PermissionRepository permissionRepository;

    public RoleResponse create(RoleRequest request){
        var role = roleMapper.toRole(request);
        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));
        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll(){
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    public void deleteRole(String roleName) {
        roleRepository.deleteById(roleName);
    }
}
