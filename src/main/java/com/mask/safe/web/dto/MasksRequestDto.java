package com.mask.safe.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
public class MasksRequestDto {

  private String name;
  private String code;
  private String company;
  private String grade;

}
