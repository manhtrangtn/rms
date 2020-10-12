package com.t1809e.rms.controller;

import com.t1809e.rms.dto.MenuDto;
import com.t1809e.rms.entity.Menu;
import com.t1809e.rms.entity.UserRole;
import com.t1809e.rms.service.MenuService;
import com.t1809e.rms.service.RoleService;
import com.t1809e.rms.utility.constance.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = Path.PATH_MENU)
public class MenuController {
    @Autowired
    public MenuService menuService;

    @Autowired
    public RoleService roleService;

    @RequestMapping(value = Path.PATH_GETs, method = RequestMethod.GET)
    public ResponseEntity<?> getMenus() {
        return ResponseEntity.ok(menuService.findAll());
    }

    @RequestMapping(value = Path.PATH_GET, method = RequestMethod.GET)
    public ResponseEntity<?> getMenu(@RequestParam String id) {
        return ResponseEntity.ok(menuService.findOne(id));
    }

    @RequestMapping(value = Path.PATH_CREATE, method = RequestMethod.POST)
    public ResponseEntity<?> createMenu(@RequestBody MenuDto menu) {
        Menu realMenu = menu.getMenu();
        realMenu.setRoles(menuService.setRoleToMenu(menu.getRoleNames()));
        menuService.save(realMenu);
        return ResponseEntity.ok("Menu successfully created!");
    }

    @RequestMapping(value = Path.PATH_UPDATE, method = RequestMethod.PUT)
    public ResponseEntity<?> updateMenu(@RequestBody MenuDto menu) {
        Menu realMenu = menu.getMenu();
        realMenu.setRoles(menuService.setRoleToMenu(menu.getRoleNames()));
        menuService.save(realMenu);
        return ResponseEntity.ok("Menu successfully updated!");
    }

    @RequestMapping(value = Path.PATH_DELETE, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMenu(@RequestParam String id) {
        menuService.delete(id);
        return ResponseEntity.ok("Menu successfully deleted!");
    }

    @RequestMapping(value = Path.PATH_GETs + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMenuByRole(@RequestParam String id) {
        return ResponseEntity.ok(menuService.findByRole(id));
    }
}
