package com.mask.safe.domain.masks;

import com.mask.safe.commons.BaseTimeEntity;
import com.mask.safe.domain.comments.Comments;
import com.mask.safe.domain.maskImages.MaskImages;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Masks extends BaseTimeEntity {

  @Id
  @Column(name = "MASK_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String code;

  @Column(nullable = false)
  private String company;

  @Column(nullable = false)
  private String grade;

  @Builder
  public Masks(String name, String code, String company, String grade) {
    this.name = name;
    this.code = code;
    this.company = company;
    this.grade = grade;
  }
}
