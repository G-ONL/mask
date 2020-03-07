package com.mask.safe.domain.masks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasksRepository extends JpaRepository<Masks, Long> {

}
