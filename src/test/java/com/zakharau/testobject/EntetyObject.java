package com.zakharau.testobject;


import static com.zakharau.entety.Priority.NOT_STATUS;
import static com.zakharau.entety.Status.NEW;

import com.zakharau.dto.topic.CreateTopic;
import com.zakharau.dto.topic.ReadTopic;
import com.zakharau.dto.translate.CreateTranslate;
import com.zakharau.dto.translate.ReadTranslate;
import com.zakharau.dto.word.CreateWord;
import com.zakharau.dto.word.ReadWord;
import com.zakharau.dto.wordInfo.CreateWordInfo;
import com.zakharau.dto.wordInfo.ReadWordInfo;
import com.zakharau.dto.wordInfo.SaveWordInfo;
import com.zakharau.entety.Topic;
import com.zakharau.entety.Translate;
import com.zakharau.entety.Word;
import com.zakharau.entety.WordInfo;
import java.time.LocalDate;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EntetyObject {

  public static Topic getTopic() {
    return Topic.builder()
        .id(1L)
        .topicName("all")
        .build();
  }

  public static CreateTopic getCreateTopic() {
    return CreateTopic.builder()
        .topicName("all")
        .build();
  }

  public static ReadTopic getReadTopic() {
    return ReadTopic.builder()
        .id(1L)
        .topicName("all")
        .build();
  }


  public static Translate getTranslate() {
    return Translate.builder()
        .id(2L)
        .translate("стоп")
        .build();
  }

  public static CreateTranslate getCreateTranslate() {
    return CreateTranslate.builder()
        .translate("стоп")
        .build();
  }

  public static ReadTranslate getReadTranslate() {
    return ReadTranslate.builder()
        .id(2L)
        .translate("стоп")
        .build();
  }


  public static Word getWord() {
    return Word.builder()
        .id(13L)
        .word("stop")
        .build();
  }


  public static CreateWord getCreateWord() {
    return CreateWord.builder()
        .word("stop")
        .build();
  }

  public static ReadWord getReadWord() {
    return ReadWord.builder()
        .id(13L)
        .word("stop")
        .build();
  }

  public static CreateWordInfo getCreateWordInfo() {
    return CreateWordInfo.builder()
        .countRepeat(0)
        .createDate(LocalDate.now())
        .lastRepeatDate(LocalDate.now())
        .status("NEW")
        .priority("NOT_STATUS")
        .translate(getCreateTranslate())
        .topic(getCreateTopic())
        .word(getCreateWord())
        .build();
  }

  public static SaveWordInfo getSaveWordInfo() {
    return SaveWordInfo.builder()
        .createDate(LocalDate.now())
        .lastRepeatDate(LocalDate.now())
        .status("NEW")
        .priority("NOT_STATUS")
        .countRepeat(0)
        .translate(getReadTranslate())
        .topic(getReadTopic())
        .word(getReadWord())
        .build();
  }

  public static WordInfo getWordInfo() {
    return WordInfo.builder()
        .id(3L)
        .createDate(LocalDate.now())
        .lastRepeatDate(LocalDate.now())
        .status(NEW)
        .priority(NOT_STATUS)
        .countRepeat(0)
        .translate(getTranslate())
        .topic(getTopic())
        .word(getWord())
        .build();
  }

  public static ReadWordInfo getReadWordInfo() {
    return ReadWordInfo.builder()
        .id(3L)
        .createDate(LocalDate.now())
        .lastRepeatDate(LocalDate.now())
        .status("NEW")
        .priority("NOT_STATUS")
        .countRepeat(0)
        .translate(getReadTranslate())
        .topic(getReadTopic())
        .word(getReadWord())
        .build();
  }

}
