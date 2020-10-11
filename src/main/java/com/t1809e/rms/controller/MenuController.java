package com.t1809e.rms.controller;

import com.t1809e.rms.entity.Menu;
import com.t1809e.rms.service.MenuService;
import com.t1809e.rms.utility.constance.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = Path.PATH_MENU)
public class MenuController {
    @Autowired
    public MenuService menuService;

    @RequestMapping(value = Path.PATH_GETs, method = RequestMethod.GET)
    public ResponseEntity<?> getMenus() {
        return ResponseEntity.ok(menuService.findAll());
    }

    @RequestMapping(value = Path.PATH_GET, method= RequestMethod.GET)
    public ResponseEntity<?> getMenu(@RequestParam String id) {
        return ResponseEntity.ok(menuService.findOne(id));
    }

    @RequestMapping(value = Path.PATH_CREATE, method = RequestMethod.POST)
    public ResponseEntity<?> createMenu(@RequestBody Menu menu) {
        //Menu newMenu = menu.getMenu();
        // fine Role by id
        // newMenu.setRoles();
        menuService.save(menu);
        return ResponseEntity.ok("Menu successfully created!");
    }

    @RequestMapping(value = Path.PATH_UPDATE, method = RequestMethod.PUT)
    public ResponseEntity<?> updateMenu(@RequestBody Menu menu) {
        menu.setUpdatedAt(LocalDateTime.now());
        menuService.save(menu);
        return ResponseEntity.ok("Menu successfully updated!");
    }

    @RequestMapping(value = Path.PATH_DELETE, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMenu(@RequestParam String id) {
        menuService.delete(id);
        return ResponseEntity.ok("Menu successfully deleted!");
    }
}
