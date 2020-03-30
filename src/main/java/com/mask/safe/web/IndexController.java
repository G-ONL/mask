package com.mask.safe.web;

import com.mask.safe.domain.masks.Masks;
import com.mask.safe.service.MasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

  private final MasksService masksService;

  @GetMapping("/")
  public String index(Model model, Pageable pageable) {
    Page<Masks> masksPage = masksService.findAll(pageable);
    model.addAttribute("masks", masksPage);
    return "index";
  }
}
