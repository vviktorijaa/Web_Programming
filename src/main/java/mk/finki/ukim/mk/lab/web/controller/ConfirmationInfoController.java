package mk.finki.ukim.mk.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ConfirmationInfo")
public class ConfirmationInfoController {

    @GetMapping
    public String getConfirmationInfoPage(Model model){
        model.addAttribute("bodyContent", "confirmationInfo");
        return "master-template";
    }
}
