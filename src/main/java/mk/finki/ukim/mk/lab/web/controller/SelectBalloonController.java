package mk.finki.ukim.mk.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/selectBalloon")
public class SelectBalloonController {

    @GetMapping
    public String getSelectSizePage(HttpServletRequest request,
                                    Model model){
        request.getSession().setAttribute("color", request.getParameter("color"));
        model.addAttribute("bodyContent", "selectBalloonSize");
        return "master-template";
    }

    @PostMapping
    public String postMethod(@RequestParam (required = false) String size,
                      HttpServletRequest request){
        request.getSession().setAttribute("size", size);
        return "redirect:/BalloonOrder.do";
    }
}
