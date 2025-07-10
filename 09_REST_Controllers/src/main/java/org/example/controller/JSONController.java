package org.example.controller;

import org.example.dto.UCity;
import org.example.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("json")
public class JSONController {
    //6
    @PostMapping(value = "save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postJson(@RequestBody UserDto userDto) {
       System.out.println(userDto);
       return "success";
    }
    
    @GetMapping("get")
    public UserDto getUser() {
        UserDto userDto = new UserDto();
        userDto.setUserId("U001");
        userDto.setUserName("Vinod");
        userDto.setAddress("Moratuwa");
        userDto.setuCity(new UCity("Colombo", "10400"));
        return userDto;
    }
}
