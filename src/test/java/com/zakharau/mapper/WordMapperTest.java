package com.zakharau.mapper;


import static com.zakharau.mapper.WordMapper.WORD_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.zakharau.dto.word.CreateWord;
import com.zakharau.dto.word.ReadWord;
import com.zakharau.entety.Word;
import com.zakharau.testobject.EntetyObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WordMapperTest {


  private final Word word = EntetyObject.getWord();

  private final CreateWord createWord = EntetyObject.getCreateWord();
  private final ReadWord readWord = EntetyObject.getReadWord();


  @Test
  void wordFromCreateWord() {

    Word word = WORD_MAPPER.wordFromCreateWord(createWord);

    assertNotNull(word);
    assertEquals(word.getWord(), createWord.getWord());
    assertNull(word.getId());
  }

  @Test
  void readWordFromWord() {

    ReadWord dto = WORD_MAPPER.readWordFromWord(word);

    assertNotNull(dto);
    assertEquals(dto.getWord(), word.getWord());
    assertEquals(dto.getId(), word.getId());
  }

  @Test
  void wordFromReadWord() {

    Word getWord = WORD_MAPPER.wordFromReadWord(readWord);

    assertNotNull(getWord);
    assertEquals(getWord.getWord(), readWord.getWord());
    assertEquals(getWord.getId(), readWord.getId());
  }

}