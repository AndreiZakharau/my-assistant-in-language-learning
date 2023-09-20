package com.zakharau.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.zakharau.dto.topic.ReadTopic;
import com.zakharau.dto.translate.ReadTranslate;
import com.zakharau.dto.word.ReadWord;
import com.zakharau.dto.wordInfo.CreateWordInfo;
import com.zakharau.dto.wordInfo.ReadWordInfo;
import com.zakharau.dto.wordInfo.SaveWordInfo;
import com.zakharau.entety.WordInfo;
import com.zakharau.mapper.WordInfoMapper;
import com.zakharau.repository.WordInfoRepo;
import com.zakharau.service.TopicService;
import com.zakharau.service.TranslateService;
import com.zakharau.service.WordService;
import com.zakharau.testobject.EntetyObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WordInfoServiceImplTest {

  @InjectMocks
  WordInfoServiceIpl wordInfoServiceIpl;
  @Mock
  WordInfoRepo wordInfoRepo;
  @Mock
  WordInfoMapper wordInfoMapper;
  @Mock
  WordService wordService;
  @Mock
  TopicService topicService;
  @Mock
  TranslateService translateService;

  private final ReadWordInfo readWordInfo = EntetyObject.getReadWordInfo();
  private final WordInfo wordInfo = EntetyObject.getWordInfo();
  private final SaveWordInfo saveWordInfo = EntetyObject.getSaveWordInfo();
  private final CreateWordInfo createWordInfo = EntetyObject.getCreateWordInfo();
  private final ReadWord readWord = EntetyObject.getReadWord();
  private final ReadTranslate readTranslate = EntetyObject.getReadTranslate();
  private final ReadTopic readTopic = EntetyObject.getReadTopic();


  @Test
  void saveWordInfo() {

    when(wordService.add(createWordInfo.getWord())).thenReturn(readWord);
    when(topicService.add(createWordInfo.getTopic())).thenReturn(readTopic);
    when(translateService.add(createWordInfo.getTranslate())).thenReturn(readTranslate);
    when(wordInfoMapper.saveWordInfoFromCreateWordInfo(createWordInfo)).thenReturn(saveWordInfo);
    when(wordInfoMapper.wordInfoFromSaveWordInfo(saveWordInfo)).thenReturn(wordInfo);
    when(wordInfoMapper.readWordInfoFromWordInfo(wordInfo)).thenReturn(readWordInfo);
    when(wordInfoRepo.save(wordInfo)).thenReturn(wordInfo);

    ReadWordInfo actual = wordInfoServiceIpl.add(createWordInfo);

    assertNotNull(actual);
    assertEquals(actual.getId(), wordInfo.getId());
    assertEquals(actual.getTopic().getTopicName(), createWordInfo.getTopic().getTopicName());
    assertEquals(actual.getWord().getWord(), createWordInfo.getWord().getWord());
    assertEquals(actual.getStatus(), createWordInfo.getStatus());
  }


}
