package com.zakharau.dto.word;

import com.zakharau.dto.topic.TopicDto.TopicDto;
import com.zakharau.dto.translate.TranslateDto.TranslateDto;
import java.time.LocalDate;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordDto {

  private long id;
  private String word;
  private LocalDate createDate;
  private LocalDate lastRepeatDate;
  private String status;
  private String priority;
  private Set<TranslateDto> translateList;
  private Set<TopicDto> topicList;
  private int countRepeat;

}
