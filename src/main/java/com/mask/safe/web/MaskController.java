package com.mask.safe.web;

import com.mask.safe.service.MasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MaskController {

  private final MasksService masksService;

}
