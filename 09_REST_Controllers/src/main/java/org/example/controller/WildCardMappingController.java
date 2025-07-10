package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("wild")
@RestController
public class WildCardMappingController {
    //4
    //Wild Card Mapping

    //wild/test/abc/hello
    //wild/test/abc123/hello

    //wild/test/hello- not worked
    //wild/test/123/hell- not worked
    //wild/test/abc123/de/hello- not worked
    @GetMapping("/test/*/hello")
    public String wildCardMapping() {
        return "WildCardMappingController";
    }

    @GetMapping("/hello/*/*")
    public String wildCardMapping2() {
        return "WildCardMappingController--->2";
    }
}
