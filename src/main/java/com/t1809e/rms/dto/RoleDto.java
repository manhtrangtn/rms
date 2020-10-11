package com.t1809e.rms.dto;

import com.t1809e.rms.entity.UserRole;

import java.util.List;

public class RoleDto {
    private UserRole role;
    private List<String> menuNames;

    public RoleDto() {
    }

    public RoleDto(UserRole role, List<String> menuNames) {
        this.role = role;
        this.menuNames = menuNames;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<String> getMenuNames() {
        return menuNames;
    }

    public void setMenuNames(List<String> menuNames) {
        this.menuNames = menuNames;
    }
}
