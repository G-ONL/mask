package com.mask.safe.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/index")
  public String newIndex() {
    return "page/index";
  }
}

