package demo.asd.dynamic_config.setup_application.controller;

import demo.asd.dynamic_config.Application;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SetupController {
    @GetMapping("/")
    public String show() {
//        TODO: show configuration form

        return "setup_form";
    }

    @PostMapping("/update")
    public String update() {
//        TODO: save configuration to .config file

        Application.restart();
        return "configuration_saved";
    }
}
