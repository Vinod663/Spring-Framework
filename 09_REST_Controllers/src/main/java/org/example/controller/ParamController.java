package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("param")
public class ParamController {
    //8
    /*param?ID=3456*/
    @GetMapping(params = {"ID"})
    public String param(@RequestParam("ID") String id) {
        return "ID: " + id;
    }

    /*param?ID=3456&name=Vinod*/
    @GetMapping(params = {"ID","name"})
    public String param(@RequestParam("ID") String id, @RequestParam("name") String name) {
        return "ID: " + id+" "+"Name: "+name;
    }

    //param/4434?id=3456&name=Vinod---------->path={code}
    //param/Code/4434?id=3456&name=Vinod----->path=Code/{code}
    @GetMapping(path="Code/{code}", params = {"id","name"})
    public String param(@PathVariable("code") String code, @RequestParam("id") String id, @RequestParam("name") String name) {
        return "ID: " + id+" "+"Code: "+code+" "+"Name: "+name;
    }
}
