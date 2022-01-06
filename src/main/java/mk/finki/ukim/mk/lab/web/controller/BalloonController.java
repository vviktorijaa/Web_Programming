package mk.finki.ukim.mk.lab.web.controller;

import jdk.jshell.MethodSnippet;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.exceptions.BalloonAlreadyExistsException;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
                              @RequestParam String description,
                              @RequestParam Long id, Model model){
        try{
            this.balloonService.save(name, description, id);
        }
        catch (BalloonAlreadyExistsException ex){
            model.addAttribute("hasError", true);
            model.addAttribute("error", ex.getMessage());
        }
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

    @PostMapping
    public String getNextPage(@ModelAttribute("color") String color){
        return "selectBalloonSize";
    }

    @PostMapping("/add-balloon/{id}")
    public String getShoppingCart(@PathVariable Long id){
        return "shoppingCart";
    }
}
