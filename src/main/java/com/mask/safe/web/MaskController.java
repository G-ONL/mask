package com.mask.safe.web;

import com.mask.safe.service.MasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class MaskController {

  private final MasksService masksService;

  @GetMapping("/search")
  public String index(Model model, @RequestParam(value = "name") String name
      , @RequestParam(value = "code") String code
      , @RequestParam(value = "company") String company
      , @RequestParam(value = "grade") String grade) {
    model.addAttribute("masks", masksService.find(name, code, company, grade));
    return "index";
  }
}
