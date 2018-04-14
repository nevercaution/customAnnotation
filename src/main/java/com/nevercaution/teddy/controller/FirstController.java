package com.nevercaution.teddy.controller;

import com.nevercaution.teddy.annotation.RequestCustomParam;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(@RequestCustomParam(value = "uid") Integer uid) {
        return "your id : " + uid;
    }
}
