package com.mask.safe.service;

import com.mask.safe.domain.masks.MasksRepository;
import com.mask.safe.web.dto.MasksListResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MasksService {

  private final MasksRepository masksRepository;

  public List<MasksListResponseDto> findAll() {
    return masksRepository.findAll().stream().map(MasksListResponseDto::new)
        .collect(Collectors.toList());
  }

  public List<MasksListResponseDto> find(String name, String code, String company, String grade) {
    return masksRepository.findBySearch(name, code, company, grade).stream()
        .map(MasksListResponseDto::new).collect(Collectors.toList());
  }
}
