package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "detect")
public class UndetectedController {

    @GetMapping
    public String getDetection(){
        return "am I detected?";
    }
}
