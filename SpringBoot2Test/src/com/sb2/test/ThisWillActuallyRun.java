package com.sb2.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ThisWillActuallyRun {

    @RequestMapping("/")
    public String getHome() {
        return "Hello World!";
    }

}
