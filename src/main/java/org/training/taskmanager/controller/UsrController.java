package org.training.taskmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.training.taskmanager.object.usr.UsrCreateReq;
import org.training.taskmanager.service.UsrService;

@RestController
public class UsrController {
    private final UsrService usrService;

    public UsrController(UsrService usrService) {
        this.usrService = usrService;
    }

    @PostMapping("/registration")
    public ResponseEntity<Long> createUsr(@RequestBody UsrCreateReq createReq) {
        return ResponseEntity.ok(usrService.createUser(createReq));
    }
}
