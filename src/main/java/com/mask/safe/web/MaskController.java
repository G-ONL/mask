package com.mask.safe.web;

import com.mask.safe.domain.masks.Masks;
import com.mask.safe.service.MasksService;
import com.mask.safe.web.dto.MasksRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MaskController {

  private final MasksService masksService;

  @GetMapping("/search")
  public Page<Masks> search(Model model
      , @RequestParam("name") String name
      , @RequestParam("company") String company
      , @RequestParam("code") String code
      , @RequestParam("grade") String grade
      , Pageable pageable) {

    MasksRequestDto masksRequestDto = MasksRequestDto.builder()
        .name(name)
        .code(code)
        .company(company)
        .grade(grade)
        .build();

    Page<Masks> masksPage = masksService.findBySearch(masksRequestDto, pageable);
    return masksPage;
  }
}
