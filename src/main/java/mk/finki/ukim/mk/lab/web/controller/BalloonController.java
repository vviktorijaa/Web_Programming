package mk.finki.ukim.mk.lab.web.controller;

import jdk.jshell.MethodSnippet;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("balloons", balloonService.listAll());
        return "listBalloons";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name,
                              @RequestParam String description){
        this.balloonService.save(name, description); //manufacturer id
        return "redirect:/balloons";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model){
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "add-balloon";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model){
        if(this.balloonService.findByid(id).isPresent()){
            Balloon b = this.balloonService.findByid(id).get();
            List<Manufacturer> m = this.manufacturerService.findAll();
            model.addAttribute("manufacturers", m);
            model.addAttribute("balloon", b);
            return "add-balloon";
        }
        return "redirect:/balloons";
    }
}
