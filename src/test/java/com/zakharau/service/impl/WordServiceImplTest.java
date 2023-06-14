package com.zakharau.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.zakharau.dto.word.WordDto;
import com.zakharau.entety.Status;
import com.zakharau.entety.Word;
import com.zakharau.mapper.WordMapper;
import com.zakharau.repository.WordRepo;
import com.zakharau.testobject.EntetyObject;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WordServiceImplTest {

  @InjectMocks
  WordServiceImpl wordService;
  @Mock
  private WordRepo wordRepo;
  @Mock
  private WordMapper wordMapper;


  private final WordDto wordDto = EntetyObject.getWordDto();
  private final Word word = EntetyObject.getWord();

  @Test
  void addWord() {

    when(wordRepo.save(word)).thenReturn(word);
    when(wordMapper.toWord(wordDto)).thenReturn(word);
    when(wordMapper.toWordDto(word)).thenReturn(wordDto);
    WordDto actual = wordService.add(wordDto);

    assertEquals(actual.getWord(), word.getWord());
    assertEquals(actual.getId(), word.getId());
    assertEquals(actual.getLastRepeatDate(), LocalDate.now());
  }

  @Test
  void deleteWordByWord() {

    Word word1 = new Word();
    word1.setWord("tea");
    String entryWord = "tea";
    String message = "Word " + entryWord + " was deleted";

    List<Word> wordList = List.of(word, word1);
    assertEquals(wordList.size(), 2);

    when(wordRepo.findAllByWord(entryWord)).thenReturn(wordList);

    String actual = wordService.delete(entryWord);

    verify(wordRepo, times(1)).deleteWordByWord(entryWord);
    verify(wordRepo, times(1)).findAllByWord(entryWord);

    assertNotNull(actual);
    assertEquals(actual, message);
  }

  @Test
  void deleteWordByWordIfNoSuchWordThenThrowEntityNotFoundException() {

    List<Word> list = new ArrayList<>();
    String entryWord = "stop";
    String message = String.format("Incorrect word: %s", word);

    assertEquals(list.size(), 0);

    when(wordRepo.findAllByWord(entryWord)).thenReturn(list);

    assertThrows(EntityNotFoundException.class, () -> wordService.delete(entryWord), message);

    verify(wordRepo, times(1)).findAllByWord(entryWord);
    verify(wordRepo, times(0)).deleteWordByWord(entryWord);

  }

  @Test
  void update() {

    String entryWord = "stop";
    long id = 13L;
    wordDto.setStatus("REPEAT");
    Word updatedWord = Word.builder().id(id).word(entryWord).status(Status.REPEAT).build();

    when(wordRepo.findAllByWord(wordDto.getWord())).thenReturn(List.of(word));
    when(wordMapper.toWord(wordDto)).thenReturn(updatedWord);
    when(wordMapper.toWordDto(updatedWord)).thenReturn(wordDto);
    when(wordRepo.saveAndFlush(updatedWord)).thenReturn(updatedWord);

    WordDto actual = wordService.update(wordDto);

    assertNotNull(actual);
    assertEquals(actual.getId(), wordDto.getId());
    assertEquals(actual.getStatus(), String.valueOf(updatedWord.getStatus()));
  }

  @Test
  void testUpdateThrowEntityNotFoundExceptionIfWordIsIncorrect() {

    List<Word> list = new ArrayList<>();
    String entryWord = "stop";
    String message = String.format("Incorrect word: %s", word);

    assertEquals(list.size(), 0);

    when(wordRepo.findAllByWord(entryWord)).thenReturn(list);

    assertThrows(EntityNotFoundException.class, () -> wordService.update(wordDto), message);

    verify(wordRepo, times(1)).findAllByWord(entryWord);
    verify(wordRepo, times(0)).deleteWordByWord(entryWord);

  }

  @Test
  void getAllWordByWord() {

    String entryWord = "eat";
    Word word1 = Word.builder().word("tea").build();

    List<Word> wordList = List.of(word1, word);

    assertEquals(wordList.size(), 2);

    when(wordRepo.findAllByWord(entryWord)).thenReturn(List.of(word));

    List<Word> actualList = wordService.getAllWordByWord(entryWord);

    assertNotNull(actualList);
    assertNotEquals(actualList.size(), wordList);
    assertEquals(actualList.size(), 1);
  }
}