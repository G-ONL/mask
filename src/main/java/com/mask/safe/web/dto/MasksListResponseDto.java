package com.mask.safe.web.dto;

import com.mask.safe.domain.masks.Masks;

public class MasksListResponseDto {

  private Long id;
  private String name;
  private String code;
  private String company;
  private String grade;

  public MasksListResponseDto(Masks masks) {
    this.id = masks.getId();
    this.name = masks.getName();
    this.code = masks.getCode();
    this.company = masks.getCompany();
    this.grade = masks.getGrade();
  }

}
