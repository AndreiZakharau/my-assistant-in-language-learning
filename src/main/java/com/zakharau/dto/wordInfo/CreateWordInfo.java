package com.zakharau.dto.wordInfo;

import com.zakharau.dto.topic.CreateTopic;
import com.zakharau.dto.translate.CreateTranslate;
import com.zakharau.dto.word.CreateWord;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateWordInfo {

  private LocalDate createDate;
  private LocalDate lastRepeatDate;
  private String status;
  private String priority;
  private int countRepeat;
  private CreateTranslate translate;
  private CreateTopic topic;
  private CreateWord word;
}
