package com.mask.safe.service;

import com.mask.safe.domain.masks.Masks;
import com.mask.safe.domain.masks.MasksRepository;
import com.mask.safe.web.dto.MasksRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MasksService {

  private final MasksRepository masksRepository;

  public Page<Masks> findAll(Pageable pageable) {
    return masksRepository.findAll(pageable);
  }

  public Page<Masks> findBySearch(MasksRequestDto masksRequestDto, Pageable pageable) {
    String name = masksRequestDto.getName();
    String code = masksRequestDto.getCode();
    String company = masksRequestDto.getCompany();
    String grade = masksRequestDto.getGrade();

    return masksRepository
        .findByNameContainingAndCodeContainingAndCompanyContainingAndGradeContaining(
            name, code, company, grade, pageable
        );

  }
}
