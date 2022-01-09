package mk.finki.ukim.mk.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/BalloonOrder.do")
public class BalloonOrderController {

    @GetMapping
    public String getBalloonOrderPage(Model model){
        model.addAttribute("bodyContent", "deliveryInfo");
        return "master-template";
    }

    @PostMapping
    public String postMethod(@RequestParam (required = false) String clientName,
                             @RequestParam (required = false) String clientAddress,
                             HttpServletRequest request){
        request.getSession().setAttribute("clientName", clientName);
        request.getSession().setAttribute("clientAddress", clientAddress);
        request.getSession().setAttribute("ipAddress", request.getRemoteAddr());
        request.getSession().setAttribute("userAgent", request.getHeader("User-Agent"));
        return "redirect:/ConfirmationInfo";
    }
}
