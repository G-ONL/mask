package com.mask.safe.domain.masks;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MasksRepository extends JpaRepository<Masks, Long> {

  @Query("SELECT p FROM Masks p where p.name like  CONCAT('%',:name,'%') and p.code like CONCAT('%',:code,'%') and p.company like CONCAT('%',:company,'%')  and p.grade like CONCAT('%',:grade,'%') ")
  List<Masks> findBySearch(@Param("name") String name, @Param("code") String code,
      @Param("company") String company, @Param("grade") String grade);

}
