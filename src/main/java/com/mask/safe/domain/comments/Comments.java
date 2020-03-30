package com.mask.safe.domain.comments;

import com.mask.safe.commons.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity {

  @Id
  @Column(name = "COMMENT_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String comment;

  @Column(nullable = false)
  private int score;

  @Column(nullable = false)
  private String password;

}
