package com.mask.safe.domain.masks;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MasksRepositoryTest {

  @Autowired
  private MasksRepository masksRepository;

  private String name = "마스크";
  private String code = "20191123";
  private String company = "마스크회사";
  private String grade = "KF94";
  private Pageable pageable;

  @Before
  public void setUp() {
    pageable = PageRequest.of(0, 20);

    masksRepository.save(Masks.builder()
        .name(name)
        .code(code)
        .company(company)
        .grade(grade)
        .build());
  }

  @After
  public void cleanUp() {
    masksRepository.deleteAll();
  }

  @Test
  public void 마스크_저장() {
    //when
    List<Masks> masksList = masksRepository.findAll();
    //then
    Masks masks = masksList.get(0);
    assertThat(masks.getName()).isEqualTo(name);
    assertThat(masks.getCode()).isEqualTo(code);
  }

  @Test
  public void 마스크_전체_검색() {
    //when
    Page<Masks> masksPage = masksRepository
        .findByNameContainingAndCodeContainingAndCompanyContainingAndGradeContaining(name, code,
            company, grade, pageable);
    List<Masks> masksList = masksPage.get().collect(Collectors.toList());

    //then
    assertThat(masksPage.getTotalElements()).isEqualTo(1);
    Masks masks = masksList.get(0);
    assertThat(masks.getName()).isEqualTo(name);
    assertThat(masks.getCode()).isEqualTo(code);
  }

  @Test
  public void 마스크_빈값_검색() {
    //when
    Page<Masks> masksPage = masksRepository
        .findByNameContainingAndCodeContainingAndCompanyContainingAndGradeContaining("", "", "", "",
            pageable);
    List<Masks> masksList = masksPage.get().collect(Collectors.toList());
    //then
    Masks masks = masksList.get(0);
    assertThat(masks.getName()).isEqualTo(name);
    assertThat(masks.getCode()).isEqualTo(code);
  }

  @Test
  public void 마스크_포함_나머지는_입력_검색() {
    //when
    Page<Masks> masksPage = masksRepository
        .findByNameContainingAndCodeContainingAndCompanyContainingAndGradeContaining("스크", code,
            company, grade, pageable);
    List<Masks> masksList = masksPage.get().collect(Collectors.toList());
    //then
    Masks masks = masksList.get(0);
    assertThat(masks.getName()).isEqualTo(name);
    assertThat(masks.getCode()).isEqualTo(code);
  }

  @Test
  public void 마스크_포함_검색() {
    //when
    Page<Masks> masksPage = masksRepository
        .findByNameContainingAndCodeContainingAndCompanyContainingAndGradeContaining("스크", "", "",
            "", pageable);
    List<Masks> masksList = masksPage.get().collect(Collectors.toList());

    //then
    Masks masks = masksList.get(0);
    assertThat(masks.getName()).isEqualTo(name);
    assertThat(masks.getCode()).isEqualTo(code);
  }


}