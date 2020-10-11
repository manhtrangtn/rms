package com.t1809e.rms.service;

import com.sun.istack.NotNull;
import com.t1809e.rms.entity.Menu;
import com.t1809e.rms.entity.UserRole;
import com.t1809e.rms.repository.UserRoleRepository;
import com.t1809e.rms.utility.constance.RoleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    UserRoleRepository roleRepository;

    @Autowired
    MenuService menuService;

    public List<UserRole> findAll() {
        return roleRepository.findAll();
    }

    public UserRole findOne(String id) {
        return roleRepository.findById(id).orElse(null);
    }

    public void save(UserRole role) {
        role.setStatus(RoleStatus.ACTIVE);
        roleRepository.save(role);
    }

    public void delete(String id) {
        Optional<UserRole> role = roleRepository.findById(id);
        if(role.isPresent()) {
            UserRole realRole = role.get();
            realRole.setStatus(RoleStatus.ACTIVE);
            roleRepository.save(realRole);
        }
    }

    @NotNull
    public List<Menu> setMenuToRole(List<String> menuNames) {
        List<Menu> menus = new ArrayList<>();
            for (String menuName:
                    menuNames) {
                Menu menu = menuService.findOne(menuName);
                if(menu != null) {
                    menus.add(menu);
                }
            }
            return menus;
    }
}
