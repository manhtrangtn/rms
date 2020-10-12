package com.t1809e.rms.controller;

import com.t1809e.rms.dto.CommonResponse;
import com.t1809e.rms.entity.User;
import com.t1809e.rms.utility.constance.Path;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value= Path.PATH_USER)
public class UserController {

    @RequestMapping(path = Path.PATH_GET, method = RequestMethod.GET)
    public ResponseEntity<?> getUser(){
        return ResponseEntity.ok(new CommonResponse());
    }
}
