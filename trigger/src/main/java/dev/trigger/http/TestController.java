package dev.trigger.http;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "t1", method = RequestMethod.GET)
    public String hello() {
        return "Hello, World!";
    }
}
