package pro.sky.java.course2.hw_spring_boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {
        @Value("${app.env}")
        String appInfo;

        @GetMapping("/appInfo")
        public String getAppInfo() {
            return appInfo;
        }
    }