package com.mask.safe.web;

import com.mask.safe.service.MasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  @Autowired
  MasksService masksService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("masks", masksService.findAll());
    return "index";
  }

}
