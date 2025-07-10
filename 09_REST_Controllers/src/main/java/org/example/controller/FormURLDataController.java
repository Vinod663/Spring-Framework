package org.example.controller;

import org.example.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("form")
public class FormURLDataController {
    //5(X-WWW-form-urlencoded)
    /*@PostMapping("save")
    public String saveUser(@RequestParam("userId")String userId,@RequestParam("userName")String userName,@RequestParam("address")String address) {
        return "User ID: "+userId+", User Name: "+userName+", Address: "+address;
    }*/

    /*@PostMapping("save")
    public String saveUser(@RequestParam String userId,@RequestParam String userName,@RequestParam String address) {
        return "User ID: "+userId+", User Name: "+userName+", Address: "+address;
    }*//*this gives Error -500 ------->This form relies on the Java compiler keeping the parameter names (userId, userName, address) in the .class file — but by default, Java does not do that!
    So Spring is confused:, “I see @RequestParam, but I don’t know what request parameter to bind it to.
    👉 Always write parameter names like this: @RequestParam("userId") String userId
    Especially for Spring MVC + REST APIs.”
    *//*
    //*/



    /*@PostMapping("save")
    public String saveUser(@RequestParam Map<String, String> formData) {
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return "success";
    }*/

    /*@PostMapping("save")
    public String saveUser(@ModelAttribute UserDto userDto) {//ModelAttribute----------->X-WWW-Form-Url-Encoded type එකේ data, dto එකකට fill කරගන්න use කරයි.
        System.out.println(userDto);
        return "success";
    }*/




/*
            | Annotation                    | Must match Postman/form key?           | Notes                                         |
            | ----------------------------- | -------------------------------------- | --------------------------------------------- |
            | `@RequestParam("userId")`     | ✅ Yes                                 | `"userId"` must match the key name in request |
            | `@RequestParam String userId` | ✅ Yes                                 | Works if variable name = key name             |
            | Key and param name different? | ❌ Won't work unless mapped explicitly |                                               |
*/

}
