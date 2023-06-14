package com.zakharau.mapper;


import static com.zakharau.mapper.WordMapper.WORD_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.zakharau.dto.word.ViewWordDto;
import com.zakharau.dto.word.WordDto;
import com.zakharau.entety.Word;
import com.zakharau.testobject.EntetyObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WordMapperTest {

  private final WordDto wordDto = EntetyObject.getWordDto();

  private final Word word = EntetyObject.getWord();

  private final ViewWordDto viewWordDto = EntetyObject.getViewWordDto();

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