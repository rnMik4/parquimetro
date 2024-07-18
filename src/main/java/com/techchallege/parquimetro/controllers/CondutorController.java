package com.techchallege.parquimetro.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condutor")
public class CondutorController {
    @GetMapping("/testapi")
    public ResponseEntity<String> getstatusApp() {
        return ResponseEntity.ok().body("{status: \"OK\"}");
    }
}
