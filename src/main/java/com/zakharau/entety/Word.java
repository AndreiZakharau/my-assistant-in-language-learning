package com.zakharau.entety;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "words")
public class Word {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  private String word;
  @NotNull
  private LocalDate createDate;
  @NotNull
  private LocalDate lastRepeatDate;
  @NotNull
  @Enumerated(EnumType.STRING)
  private Status status;
  @NotNull
  @Enumerated(EnumType.STRING)
  private Priority priority;
  @NotNull
  @Min(value = 0)
  private Integer countRepeat;
  @Builder.Default
  @ToString.Exclude
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "words_translates",
      joinColumns = @JoinColumn(name = "word_id"),
      inverseJoinColumns = @JoinColumn(name = "translates_id"))

  private Set<Translate> translates = new HashSet<>();
  @Builder.Default
  @ToString.Exclude
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "words_topics",
      joinColumns = @JoinColumn(name = "word_id"),
      inverseJoinColumns = @JoinColumn(name = "topics_id"))

  private Set<Topic> topics = new HashSet<>();

  public void addTranslate(Translate translate) {
    translates.add(translate);
    translate.getWordList().add(this);
  }

  public void addTopic(Topic topic) {
    topics.add(topic);
    topic.getWords().add(this);
  }

}
