package com.zakharau.entety;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "word_nformation")
public class WordInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Word word;
  @ManyToOne
  private Translate translate;
  @ManyToOne
  private Topic topic;
  @NotNull
  private LocalDate createDate;
  @NotNull
  private LocalDate lastRepeatDate;
  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private Status status;
  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private Priority priority;
  @NotNull
  @Min(value = 0)
  private Integer countRepeat;
}
