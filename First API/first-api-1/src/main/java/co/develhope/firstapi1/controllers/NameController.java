package co.develhope.firstapi1.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 The {@code NameController} class is a Spring MVC controller that handles requests related to a name.
 */

@RestController
@RequestMapping
public class NameController {

    /**
     The name to be used in this controller.
     */
    private final String name = "Alessandro";

    /**
     Returns the name used in this controller as a string in response to a GET request to "/getname".
     @return The name used in this controller.
     */
    @GetMapping("/getname")
    public String getName(){
        return name;
    }

    /**
     Returns the reversed name used in this controller as a string in response to a POST request to "/reversename".
     @return The reversed name used in this controller.
     */
    @PostMapping("/reversename")
    public String reverseUserName(){
        return new StringBuilder(name).reverse().toString();
    }
}