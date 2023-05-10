package com.zakharau.mapper;


import static com.zakharau.mapper.WordMapper.WORD_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import org.junit.jupiter.api.Test;


class WordMapperTest {

  private final Topic topic = Topic.builder()
      .id(1L)
      .topicName("all")
      .words(Set.of(new Word()))
      .build();

  private final Translate translate = Translate.builder()
      .id(2L)
      .translate("стоп")
      .build();

  private final TopicDto topicDto = TopicDto.builder()
      .id(1L)
      .topic("all")
      .build();

  private final TranslateDto translateDto = TranslateDto.builder()
      .id(2L)
      .translate("стоп")
      .build();

  private final WordDto wordDto = WordDto.builder()
      .id(13L)
      .word("stop")
      .createDate(LocalDate.now().minusDays(1))
      .lastRepeatDate(LocalDate.now())
      .countRepeat(2)
      .priority("NOT_STATUS")
      .status("REPEAT")
      .topicList(Set.of(topicDto))
      .translateList(Set.of(translateDto))
      .build();

  private final Word word = Word.builder()
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

  private final ViewWordDto viewWordDto = ViewWordDto.builder()
      .word("stop")
      .priority(Priority.FIRST)
      .listTopic(List.of(topic))
      .listTranslate(List.of(translate))
      .build();

  @Test
  void createToWordDtoFromWord() {

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

    Word word = WORD_MAPPER.toWord(wordDto);

    assertNotNull(word);
    assertEquals(word.getWord(), wordDto.getWord());
    assertEquals(word.getCountRepeat(), wordDto.getCountRepeat());
    assertEquals(String.valueOf(word.getStatus()), wordDto.getStatus());
    assertEquals(word.getTopics().size(), wordDto.getTopicList().size());
  }


  @Test
  void createToViewWordDto() {

    ViewWordDto viewDto = WORD_MAPPER.toViewWordDto(word);

    assertNotNull(viewDto);
    assertEquals(viewDto.getWord(), word.getWord());
    assertEquals(viewDto.getListTopic().size(), word.getTopics().size());
    assertEquals(viewDto.getPriority(), word.getPriority());
  }

  @Test
  void createWordFromViewWordDto() {

    Word newWord = WORD_MAPPER.wordFromViewWordDto(viewWordDto);

    assertNotNull(newWord);
    assertEquals(newWord.getWord(), viewWordDto.getWord());
    assertEquals(newWord.getPriority(), viewWordDto.getPriority());
    assertEquals(newWord.getTopics().size(), viewWordDto.getListTopic().size());
    ;
  }

  @Test
  void createViewWordDtoFromWordDto() {

    ViewWordDto viewDto = WORD_MAPPER.viewWordDtoFromWordDto(wordDto);

    assertNotNull(viewDto);
    assertEquals(viewDto.getWord(), wordDto.getWord());
    assertEquals(viewDto.getListTopic().size(), wordDto.getTopicList().size());
    assertEquals(String.valueOf(viewDto.getPriority()), wordDto.getPriority());
    assertEquals(viewDto.getListTranslate().size(), wordDto.getTranslateList().size());

  }

  @Test
  void createWordDtoFromViewWordDto() {

    WordDto dto = WORD_MAPPER.wordDtoFromViewWordDto(viewWordDto);

    assertNotNull(dto);
    assertEquals(dto.getWord(), viewWordDto.getWord());
    assertEquals(dto.getTopicList().size(), viewWordDto.getListTopic().size());
    assertEquals(dto.getPriority(), String.valueOf(viewWordDto.getPriority()));
    assertEquals(dto.getTranslateList().size(), viewWordDto.getListTranslate().size());
  }


}