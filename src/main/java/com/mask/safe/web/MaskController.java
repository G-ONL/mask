package com.mask.safe.web;

import com.mask.safe.service.MasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MaskController {

  private final MasksService masksService;

}
