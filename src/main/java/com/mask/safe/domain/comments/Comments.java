package com.mask.safe.domain.comments;

import com.mask.safe.commons.BaseTimeEntity;
import com.mask.safe.domain.masks.Masks;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import jdk.internal.jline.internal.Nullable;

@Entity
public class Comments extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String comment;

  @Column(nullable = false)
  private int score;

  @Column(nullable = false)
  private String password;

}
