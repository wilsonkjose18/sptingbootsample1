package com.example.demo.controller;

import com.example.demo.service.AppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
public class AppController {

    private final AppService appService;
    
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/reverse")
    public List<List<String>> reverse() throws IOException {

        return appService.getReversedNames();

    }
}
