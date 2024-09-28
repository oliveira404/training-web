package br.com.trainingweb.iniciando_com_spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.trainingweb.iniciando_com_spring.repositories.DiaristaRepository;

@Controller
@RequestMapping("/diaristas")
public class DiaristaController {

  @Autowired
  private DiaristaRepository diaristaRepository;
  
  @GetMapping
  public ModelAndView buscarTodos() {
    var modelAndView = new ModelAndView("listar_diariastas");
    modelAndView.addObject("diaristas", diaristaRepository.findAll());
    return modelAndView;
  }

}
