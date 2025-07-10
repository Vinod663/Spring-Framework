package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.xpath.XPath;

@RequestMapping("path")
@RestController
public class PathVariableController {
    //7
    //path/12
    @GetMapping(path="{id}")
    public String hello4(@PathVariable("id") String idNum) {
        return "Hello " + idNum + "!";
    }

    //path/Vinod/65
    @GetMapping(path = "{name}/{id}")
    public String hello5(@PathVariable("name") String name, @PathVariable("id") int idNum) {
        return "ID Number:"+idNum+" "+"Name:"+name;
    }

    //path/customer/I001
    @GetMapping(path = "customer/{id:[I][0-9]{3}}")//[I][0-9]{3}}--->Regex validations
    public String hello6(@PathVariable("id") String id) {
        return "hello6 :"+ id;
    }

    //path/item/2375/branch/Colombo
    @GetMapping(path = "item/{code}/branch/{city}")
    public String hello7(@PathVariable("code") String code, @PathVariable("city") String city) {
        return "hello7: "+ code+" "+city;
    }

    //path/items/I001/branch/Colombo
    @GetMapping(path = "items/{code:[I][0-9]{3}}/branch/{city}")
    public String hello8(@PathVariable("code") String code, @PathVariable("city") String city) {
        return "hello8: "+ code+city;
    }
}
