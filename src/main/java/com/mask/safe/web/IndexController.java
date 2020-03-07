package com.mask.safe.web;

import com.mask.safe.service.MasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  @Autowired MasksService masksService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("masks", masksService.findAll());
    return "index";
  }

}
