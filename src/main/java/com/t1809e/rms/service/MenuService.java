package com.t1809e.rms.service;

import com.t1809e.rms.entity.Menu;
import com.t1809e.rms.entity.UserRole;
import com.t1809e.rms.repository.MenuRepository;
import com.t1809e.rms.utility.constance.MenuStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    @Autowired
    RoleService roleService;

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public Menu findOne(String id) {
        return menuRepository.findById(id).orElse(null);
    }

    public void save(Menu menu) {
        menu.setStatus(MenuStatus.ACTIVE);
        menuRepository.save(menu);
    }

    public void delete(String id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if(menu.isPresent()) {
            Menu realMenu = menu.get();
            realMenu.setStatus(MenuStatus.DELETED);
            menuRepository.save(menu.get());
        }
    }

    public List<UserRole> setRoleToMenu(List<String> roleNames) {
        List<UserRole> roles = new ArrayList<>();
        for (String roleName:
                roleNames) {
            UserRole role = roleService.findOne(roleName);
            if(role != null) {
                roles.add(role);
            }
        }
        return roles;
    }

    public List<Menu> findByRole(String RoleName) {
        return menuRepository.findAllByRoles(RoleName);
    }
}
