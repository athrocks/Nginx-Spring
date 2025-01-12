package com.atharva.nginxspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private Environment environment;

    @GetMapping("/")
    public String home() {

        String appName = environment.getProperty("APP_NAME");
        log.info("Request served by {}", appName);
        return "index";
    }

}
