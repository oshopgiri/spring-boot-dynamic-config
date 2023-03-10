package demo.asd.dynamic_config.main_application.controller;

import demo.asd.dynamic_config.main_application.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

//    TODO: uncomment to crash on restart
//    @Autowired
//    StudentRepository studentRepository;

    @GetMapping("/")
    public String show() {
        return "student_list";
    }
}
