package com.zakharau.testobject;

import com.zakharau.dto.topic.TopicDto.TopicDto;
import com.zakharau.dto.translate.TranslateDto.TranslateDto;
import com.zakharau.dto.word.ViewWordDto;
import com.zakharau.dto.word.WordDto;
import com.zakharau.entety.Priority;
import com.zakharau.entety.Status;
import com.zakharau.entety.Topic;
import com.zakharau.entety.Translate;
import com.zakharau.entety.Word;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EntetyObject {

  public static Topic getTopic() {
    return Topic.builder()
        .id(1L)
        .topicName("all")
        .words(Set.of(new Word()))
        .build();
  }

  public static TopicDto getTopicDto() {
    return TopicDto.builder()
        .id(1L)
        .topic("all")
        .build();
  }

  public static Translate getTranslate() {
    return Translate.builder()
        .id(2L)
        .translate("стоп")
        .build();
  }

  public static TranslateDto getTranslateDto(){
    return TranslateDto.builder()
        .id(2L)
        .translate("стоп")
        .build();
  }

  public static Word getWord() {
    return Word.builder()
        .id(13L)
        .word("stop")
        .createDate(LocalDate.now().minusDays(1))
        .lastRepeatDate(LocalDate.now())
        .countRepeat(2)
        .priority(Priority.NOT_STATUS)
        .status(Status.NEW)
        .topics(Set.of(getTopic()))
        .translates(Set.of(getTranslate()))
        .build();
  }

  public static WordDto getWordDto(){
    return WordDto.builder()
        .id(13L)
        .word("stop")
        .createDate(LocalDate.now().minusDays(1))
        .lastRepeatDate(LocalDate.now())
        .countRepeat(2)
        .priority("NOT_STATUS")
        .status("NEW")
        .topicList(Set.of(getTopicDto()))
        .translateList(Set.of(getTranslateDto()))
        .build();
  }

  public static ViewWordDto getViewWordDto(){
    return ViewWordDto.builder()
        .word("stop")
        .priority(Priority.FIRST)
        .listTopic(List.of(getTopic()))
        .listTranslate(List.of(getTranslate()))
        .build();
  }

}
