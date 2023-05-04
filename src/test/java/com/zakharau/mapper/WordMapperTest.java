package com.zakharau.mapper;


import static com.zakharau.mapper.WordMapper.WORD_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.zakharau.dto.topic.TopicDto.TopicDto;
import com.zakharau.dto.translate.TranslateDto.TranslateDto;
import com.zakharau.dto.word.WordDto;
import com.zakharau.entety.Priority;
import com.zakharau.entety.Status;
import com.zakharau.entety.Topic;
import com.zakharau.entety.Translate;
import com.zakharau.entety.Word;
import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.Test;

class WordMapperTest {

  @Test
  void createToWordDtoFromWord() {

    Topic topic = Topic.builder()
        .id(1L)
        .topicName("all")
        .words(Set.of(new Word()))
        .build();

    Translate translate = Translate.builder()
        .id(2L)
        .translate("стоп")
        .build();

    Word word = Word.builder()
        .id(13L)
        .word("stop")
        .createDate(LocalDate.now().minusDays(1))
        .lastRepeatDate(LocalDate.now())
        .countRepeat(2)
        .priority(Priority.NOT_STATUS)
        .status(Status.REPEAT)
        .topics(Set.of(topic))
        .translates(Set.of(translate))
        .build();

    WordDto wordDto = WORD_MAPPER.toWordDto(word);

    assertNotNull(wordDto);
    assertEquals(wordDto.getWord(), word.getWord());
    assertEquals(wordDto.getCountRepeat(), word.getCountRepeat());
    assertEquals(wordDto.getTopicList().size(), word.getTopics().size());
    assertEquals(wordDto.getLastRepeatDate(), word.getLastRepeatDate());
    assertNotEquals(wordDto.getCountRepeat(), 4);

  }

  @Test
  void createToWordFromWordDto() {

    TopicDto topic = TopicDto.builder()
        .id(1L)
        .topic("all")
        .build();

    TranslateDto translate = TranslateDto.builder()
        .id(2L)
        .translate("стоп")
        .build();

    WordDto wordDto = WordDto.builder()
        .id(13L)
        .word("stop")
        .createDate(LocalDate.now().minusDays(1))
        .lastRepeatDate(LocalDate.now())
        .countRepeat(2)
        .priority("NOT_STATUS")
        .status("REPEAT")
        .topicList(Set.of(topic))
        .translateList(Set.of(translate))
        .build();

    Word word = WORD_MAPPER.toWord(wordDto);

    assertNotNull(word);
    assertEquals(word.getWord(), wordDto.getWord());
    assertEquals(word.getCountRepeat(), wordDto.getCountRepeat());
    assertEquals(String.valueOf(word.getStatus()), wordDto.getStatus());
    assertEquals(word.getTopics().size(), wordDto.getTopicList().size());
  }


}