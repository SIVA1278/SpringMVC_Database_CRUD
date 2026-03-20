package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Main")
public class EmployeeController {

    @GetMapping ("/index")
    public String index()
    {
        return "index";
    }
}
