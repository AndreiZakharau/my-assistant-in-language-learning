package com.zakharau.dto.wordInfo;

import com.zakharau.dto.topic.ReadTopic;
import com.zakharau.dto.translate.ReadTranslate;
import com.zakharau.dto.word.ReadWord;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ReadWordInfo {

  private Long id;
  private LocalDate createDate;
  private LocalDate lastRepeatDate;
  private String status;
  private String priority;
  private int countRepeat;
  private ReadTranslate translate;
  private ReadTopic topic;
  private ReadWord word;
}
