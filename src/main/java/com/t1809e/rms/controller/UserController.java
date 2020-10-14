package com.t1809e.rms.controller;

import com.t1809e.rms.dto.CommonResponse;
import com.t1809e.rms.entity.User;
import com.t1809e.rms.service.UserService;
import com.t1809e.rms.utility.constance.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value= Path.PATH_USER)
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "get-user", method = RequestMethod.GET)
    ResponseEntity<?> getUser(@RequestParam String id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @RequestMapping(value = "get-users", method = RequestMethod.GET)
    ResponseEntity<?> getUsers(@RequestParam String keyword) {
        keyword = ObjectUtils.isEmpty(keyword)? "":keyword;
        return ResponseEntity.ok(userService.getUsers(keyword));
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    ResponseEntity<?> createUser(@RequestBody User user, @RequestParam String departmentId) {
        userService.saveUser(user, departmentId);
        return ResponseEntity.ok("Created successfully!");
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    ResponseEntity<?> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok("Updated successfully!");
    }

    @RequestMapping(value = "delete-user", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteUser(@RequestParam String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Deleted successfully!");
    }

}
