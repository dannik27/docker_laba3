package com.dannik.docker_master;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private FiboService fiboService;

    @Autowired
    private MainController(FiboService fiboService){
        this.fiboService = fiboService;
    };



    @RequestMapping("/")
    public String mainpage(Model model) {
        model.addAttribute("fibo", fiboService.getLastFibo());
        return "hello";
    }

    @RequestMapping(value = "/fibo", method = RequestMethod.GET)
    @ResponseBody
    public Long getLastFibo(){
        return fiboService.getLastFibo().getVal();
    }

    @RequestMapping(value = "/fibo", method = RequestMethod.PUT)
    @ResponseBody
    public String calculateNewFibo(){
        fiboService.calculateNewFibo();
        return "ok";
    }

    @RequestMapping(value = "/fibo", method = RequestMethod.DELETE)
    @ResponseBody
    public String removeFibo(){
        fiboService.removeFibo();
        return "ok";
    }

}
