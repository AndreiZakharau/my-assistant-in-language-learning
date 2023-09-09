package com.zakharau.testobject;


import com.zakharau.dto.topic.CreateTopic;
import com.zakharau.dto.topic.ReadTopic;
import com.zakharau.dto.translate.CreateTranslate;
import com.zakharau.dto.translate.ReadTranslate;
import com.zakharau.dto.word.CreateWord;
import com.zakharau.dto.word.ReadWord;
import com.zakharau.entety.Topic;
import com.zakharau.entety.Translate;
import com.zakharau.entety.Word;
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


  public static CreateWord getCreateWord(){
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

}
