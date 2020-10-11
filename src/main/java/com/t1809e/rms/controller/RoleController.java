package com.t1809e.rms.controller;

import com.t1809e.rms.dto.RoleDto;
import com.t1809e.rms.entity.Menu;
import com.t1809e.rms.entity.UserRole;
import com.t1809e.rms.service.MenuService;
import com.t1809e.rms.service.RoleService;
import com.t1809e.rms.utility.constance.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = Path.PATH_ROLE)
public class RoleController {
    @Autowired
    public RoleService roleService;

    @Autowired
    public MenuService menuService;

    @RequestMapping(value = Path.PATH_GETs, method = RequestMethod.GET)
    public ResponseEntity<?> getRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @RequestMapping(value = Path.PATH_GET, method= RequestMethod.GET)
    public ResponseEntity<?> getRole(@RequestParam String id) {
        return ResponseEntity.ok(roleService.findOne(id));
    }

    @RequestMapping(value = Path.PATH_CREATE, method = RequestMethod.POST)
    public ResponseEntity<?> createRole(@RequestBody RoleDto role) {
        UserRole realRole = role.getRole();
        realRole.setMenus(roleService.setMenuToRole(role.getMenuNames()));
        roleService.save(realRole);
        return ResponseEntity.ok("Role successfully created!");
    }

    @RequestMapping(value = Path.PATH_UPDATE, method = RequestMethod.PUT)
    public ResponseEntity<?> updateRole(@RequestBody RoleDto role) {
        UserRole realRole = role.getRole();
        realRole.setMenus(roleService.setMenuToRole(role.getMenuNames()));
        roleService.save(realRole);
        return ResponseEntity.ok("Role successfully updated!");
    }

    @RequestMapping(value = Path.PATH_DELETE, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRole(@RequestParam String id) {
        roleService.delete(id);
        return ResponseEntity.ok("Role successfully deleted!");
    }
}
