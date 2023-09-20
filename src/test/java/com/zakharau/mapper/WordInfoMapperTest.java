package com.zakharau.mapper;

import static com.zakharau.mapper.WordInfoMapper.WORD_INFO_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.zakharau.dto.wordInfo.CreateWordInfo;
import com.zakharau.dto.wordInfo.ReadWordInfo;
import com.zakharau.dto.wordInfo.SaveWordInfo;
import com.zakharau.entety.WordInfo;
import com.zakharau.testobject.EntetyObject;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WordInfoMapperTest {

  private final ReadWordInfo readWordInfo = EntetyObject.getReadWordInfo();
  private final WordInfo wordInfo = EntetyObject.getWordInfo();
  private final CreateWordInfo createWordInfo = EntetyObject.getCreateWordInfo();
  private final SaveWordInfo saveWordInfo = EntetyObject.getSaveWordInfo();

  @Test
  void wordInfoFromCreateWordInfo() {

    WordInfo actual = WORD_INFO_MAPPER.wordInfoFromCreateWordInfo(createWordInfo);

    assertNotNull(actual);
    assertEquals(String.valueOf(actual.getStatus()), createWordInfo.getStatus());
    assertEquals(actual.getWord().getWord(), createWordInfo.getWord().getWord());
    assertEquals(actual.getTranslate().getTranslate(),
        createWordInfo.getTranslate().getTranslate());
    assertEquals(actual.getTopic().getTopicName(), createWordInfo.getTopic().getTopicName());
    assertNull(actual.getId());
  }

  @Test
  void wordInfoFromSaveWordInfo() {

    WordInfo actual = WORD_INFO_MAPPER.wordInfoFromSaveWordInfo(saveWordInfo);

    assertNotNull(actual);
    assertEquals(String.valueOf(actual.getStatus()), saveWordInfo.getStatus());
    assertEquals(actual.getWord().getId(), saveWordInfo.getWord().getId());
    assertEquals(actual.getWord().getWord(), saveWordInfo.getWord().getWord());
    assertEquals(actual.getTranslate().getTranslate(), saveWordInfo.getTranslate().getTranslate());
    assertEquals(actual.getTranslate().getId(), saveWordInfo.getTranslate().getId());
    assertEquals(actual.getTopic().getTopicName(), saveWordInfo.getTopic().getTopicName());
    assertEquals(actual.getTopic().getId(), saveWordInfo.getTopic().getId());
    assertEquals(actual.getCreateDate(), LocalDate.now());
    assertNull(actual.getId());
  }

  @Test
  void readWordInfoFromWordInfo() {

    ReadWordInfo actual = WORD_INFO_MAPPER.readWordInfoFromWordInfo(wordInfo);

    assertNotNull(actual);
    assertEquals(actual.getId(), wordInfo.getId());
    assertEquals(actual.getWord().getId(), wordInfo.getWord().getId());
    assertEquals(actual.getWord().getWord(), wordInfo.getWord().getWord());
    assertEquals(actual.getTranslate().getTranslate(), wordInfo.getTranslate().getTranslate());
    assertEquals(actual.getTranslate().getId(), wordInfo.getTranslate().getId());
    assertEquals(actual.getTopic().getTopicName(), wordInfo.getTopic().getTopicName());
    assertEquals(actual.getTopic().getId(), wordInfo.getTopic().getId());
    assertEquals(actual.getCreateDate(), LocalDate.now());
    assertEquals(actual.getStatus(), String.valueOf(wordInfo.getStatus()));
  }

  @Test
  void wordInfoFromReadWordInfo() {

    WordInfo actual = WORD_INFO_MAPPER.wordInfoFromReadWordInfo(readWordInfo);

    assertNotNull(actual);
    assertEquals(actual.getId(), readWordInfo.getId());
    assertEquals(actual.getWord().getId(), readWordInfo.getWord().getId());
    assertEquals(actual.getWord().getWord(), readWordInfo.getWord().getWord());
    assertEquals(actual.getTranslate().getTranslate(), readWordInfo.getTranslate().getTranslate());
    assertEquals(actual.getTranslate().getId(), readWordInfo.getTranslate().getId());
    assertEquals(actual.getTopic().getTopicName(), readWordInfo.getTopic().getTopicName());
    assertEquals(actual.getTopic().getId(), readWordInfo.getTopic().getId());
    assertEquals(actual.getCreateDate(), LocalDate.now());
    assertEquals(String.valueOf(actual.getStatus()), readWordInfo.getStatus());
  }

  @Test
  void saveWordInfoFromCreateWordInfo() {

    SaveWordInfo actual = WORD_INFO_MAPPER.saveWordInfoFromCreateWordInfo(createWordInfo);

    assertNotNull(actual);
    assertEquals(String.valueOf(actual.getStatus()), createWordInfo.getStatus());
    assertEquals(actual.getWord().getWord(), createWordInfo.getWord().getWord());
    assertEquals(actual.getTranslate().getTranslate(),
        createWordInfo.getTranslate().getTranslate());
    assertEquals(actual.getTopic().getTopicName(), createWordInfo.getTopic().getTopicName());

  }
}
