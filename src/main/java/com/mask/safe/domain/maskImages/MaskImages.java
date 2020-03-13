package com.mask.safe.domain.maskImages;

import com.mask.safe.commons.BaseTimeEntity;
import com.mask.safe.domain.masks.Masks;
import java.util.Base64;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MaskImages extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String uri;

}
