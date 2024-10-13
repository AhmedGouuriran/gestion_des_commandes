package com.fsjdida.gestion_des_commandes.Controllers;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monolothic")
public class CustomerController {

    @GetMapping("/acceuil")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "home"; // This should correspond to a view template (e.g., hello.html or hello.jsp)
    }




}
