package com.zakharau.entety;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@ToString(exclude = "wordInfoList")
@EqualsAndHashCode(of = "translate")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "translates")
public class Translate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @Column(length = 1000, unique = true)
  private String translate;
  @Builder.Default
  @OneToMany(mappedBy = "translate")
  List<WordInfo> wordInfoList = new ArrayList<>();
}