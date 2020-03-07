package com.mask.safe.domain.masks;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MasksRepositoryTest {

  @Autowired
  private MasksRepository masksRepository;

  @After
  public void cleanUp() {
    masksRepository.deleteAll();
  }

  @Test
  public void 마스크_저장() {
    //given
    String name = "마스크";
    String code = "20191123";
    String company = "마스크회사";
    String grade = "KF94";

    masksRepository.save(Masks.builder()
        .name(name)
        .code(code)
        .company(company)
        .grade(grade)
        .build());

    //when
    List<Masks> masksList = masksRepository.findAll();
    //then
    Masks masks = masksList.get(0);
    assertThat(masks.getName()).isEqualTo(name);
    assertThat(masks.getCode()).isEqualTo(code);
  }

}
