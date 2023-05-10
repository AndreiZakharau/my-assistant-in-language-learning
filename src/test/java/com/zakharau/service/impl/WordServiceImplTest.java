package com.zakharau.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.zakharau.dto.topic.TopicDto.TopicDto;
import com.zakharau.dto.translate.TranslateDto.TranslateDto;
import com.zakharau.dto.word.WordDto;
import com.zakharau.entety.Priority;
import com.zakharau.entety.Status;
import com.zakharau.entety.Topic;
import com.zakharau.entety.Translate;
import com.zakharau.entety.Word;
import com.zakharau.mapper.WordMapper;
import com.zakharau.mapper.WordMapperImpl;
import com.zakharau.repository.WordRepo;
import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class WordServiceImplTest {

  @InjectMocks WordServiceImpl wordService;
  @Mock private WordRepo wordRepo;
  @Mock private WordMapper wordMapper;


  @BeforeEach
  void setUp() {
      MockitoAnnotations.initMocks(this);
  }

  @Test
  void addWord() {

    Topic topic = Topic.builder()
        .id(1L)
        .topicName("all")
        .words(Set.of(new Word()))
        .build();

    Translate translate = Translate.builder()
        .id(2L)
        .translate("стоп")
        .build();

    TopicDto topicDto = TopicDto.builder()
        .id(1L)
        .topic("all")
        .build();

    TranslateDto translateDto = TranslateDto.builder()
        .id(2L)
        .translate("стоп")
        .build();

    WordDto wordDto = WordDto.builder()
        .id(13L)
        .word("stop")
        .createDate(LocalDate.now())
        .lastRepeatDate(LocalDate.now())
        .countRepeat(2)
        .priority("NOT_STATUS")
        .status("REPEAT")
        .topicList(Set.of(topicDto))
        .translateList(Set.of(translateDto))
        .build();

    Word word = Word.builder()
        .id(13L)
        .word("stop")
        .createDate(LocalDate.now().minusDays(1))
        .lastRepeatDate(LocalDate.now())
        .countRepeat(0)
        .priority(Priority.NOT_STATUS)
        .status(Status.REPEAT)
        .topics(Set.of(topic))
        .translates(Set.of(translate))
        .build();

    when(wordRepo.save(word)).thenReturn(word);
    when(wordMapper.toWord(wordDto)).thenReturn(word);
    when(wordMapper.toWordDto(word)).thenReturn(wordDto);
    WordDto actual = wordService.add(wordDto);

    verify(wordRepo,times(1));
    assertEquals(actual.getWord(), word.getWord());
    assertEquals(actual.getId(), word.getId());
    assertEquals(actual.getLastRepeatDate(),LocalDate.now());
  }

  @Test
  void delete() {
  }

  @Test
  void update() {
  }
}