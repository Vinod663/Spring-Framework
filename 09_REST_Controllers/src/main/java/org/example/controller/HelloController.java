package org.example.controller;

import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping("hello")
public class HelloController {
    //1
    @GetMapping
    public String getMapping() {
        return "GET";

    }

    @GetMapping(path="get2")//path eka dun nathnm ambiguous error ekk tiyanawa kiyala enawa get methods dekk tiyana nisa
    public String getMapping2() {
        return "GET2";

    }

    @PostMapping
    public String postMapping() {
        return "POST";
    }

    @DeleteMapping
    public String deleteMapping() {
        return "DELETE";
    }

    @PutMapping
    public String putMapping() {
        return "PUT";
    }

    @PatchMapping//Update only part of the resource
    public String patchMapping() {
        return "PATCH";
    }
}
