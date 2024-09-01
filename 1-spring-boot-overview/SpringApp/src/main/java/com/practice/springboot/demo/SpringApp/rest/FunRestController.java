package com.practice.springboot.demo.SpringApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${author.name}")
    private String authorName;

    @Value("${author.age}")
    private Integer authorAge;

    @Value("${book.name}")
    private String bookName;

    // expose "/" that return "Hello World"

    @GetMapping("/greet")
    public String sayHello(){
        return "Oye! Kemon achis?";
    }

    @GetMapping("/bye")
    public String sayBye(){
        return "Bhaag Shala. Dourer upor elaka char.";
    }

    @GetMapping("/drink")
    public String drinkWater(){
        return "Paani pelo bhaiya! Scroll karte karte thak gaye honge?";
    }

    @GetMapping("/work")
    public String workhard(){
        return "Don't just eat and sleep. Work hard to get success.";
    }

    @GetMapping("/about")
    public String aboutSection(){
        return authorName + " " + authorAge + " " + bookName;
    }
}
