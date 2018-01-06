package com.dannik.docker_worker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MainController {


    FiboService fiboService;

    @Autowired
    MainController(FiboService fiboService){
        this.fiboService = fiboService;
    }


    @PutMapping("/calculate")
    public String calculateNewFibo() {
        fiboService.incrementFibo();
        return "ok";
    }

}
