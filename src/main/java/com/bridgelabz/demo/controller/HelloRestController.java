package com.bridgelabz.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.demo.model.HelloModel;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    @RequestMapping(value = {"", "/", "/home"})
    public String index() {
        return "Hello from BridgeLabz!!!";
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String Hello(@RequestParam("name") String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/param/{name}")
    public String HelloParam(@PathVariable String name) {
        return "Hello " + name + " !";
    }
    
    @PostMapping("/post")
    public String HelloPost(@RequestBody HelloModel model) {
    	return "Hello " + model.getFirstName() + "" + model.getLastName() +"!";
    }
    
    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName,
                           @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }
}
