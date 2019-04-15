package main.java.com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author arthas on 2019/4/15
 */
@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "success";
    }
}
