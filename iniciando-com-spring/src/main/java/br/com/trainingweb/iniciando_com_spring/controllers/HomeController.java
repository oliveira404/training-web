package br.com.trainingweb.iniciando_com_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import br.com.trainingweb.iniciando_com_spring.dto.DiaristForm;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @GetMapping("/modelmap")
    public String home2(ModelMap modelMap) {
        modelMap.addAttribute("nome", "Oliveira");
        return "home";
    }

    @GetMapping("/modelandview")
    public ModelAndView home3() {
        var modelAndView = new ModelAndView("home");
        modelAndView.addObject("nome", "Bahasa");
        return modelAndView;
    }

    @GetMapping("/form")
    public ModelAndView form() {
        var modelAndView = new ModelAndView("form");
        modelAndView.addObject("form", new DiaristForm());
        return modelAndView;
    }

    @PostMapping("/form")
    public String form2(DiaristForm form) {
        System.out.println(form);
        return "redirect:/form";
    }
}
