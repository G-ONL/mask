package com.mask.safe.web;

import com.mask.safe.service.MasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

  private final MasksService masksService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("masks", masksService.findAll());
    return "index";
  }

}
