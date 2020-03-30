package com.mask.safe.domain.masks;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasksRepository extends JpaRepository<Masks, Long> {

  Page<Masks> findByNameContainingAndCodeContainingAndCompanyContainingAndGradeContaining(
      String name,
      String code, String company, String grade, Pageable pageble);
}
