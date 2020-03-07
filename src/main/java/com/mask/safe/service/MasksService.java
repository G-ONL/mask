package com.mask.safe.service;

import com.mask.safe.domain.masks.MasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MasksService {

  private MasksRepository masksRepository;

}
