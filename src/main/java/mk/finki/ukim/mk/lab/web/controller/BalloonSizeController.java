package mk.finki.ukim.mk.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/selectBalloonSize")
public class BalloonSizeController {

    @GetMapping
    public String getBalloonSizePage(Model model){
        model.addAttribute("bodyContent", "selectBalloonSize");
        return "master-template";
    }
}
