package com.zakharau.service.impl;

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
import com.zakharau.service.WordInfoService;
import com.zakharau.service.WordService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WordInfoServiceIpl implements WordInfoService {

  private final WordInfoMapper wordInfoMapper;
  private final WordInfoRepo wordInfoRepo;
  private final WordService wordService;
  private final TopicService topicService;
  private final TranslateService translateService;

  @Transactional
  @Override
  public ReadWordInfo add(CreateWordInfo createWordInfo) {

    if (createWordInfo.getPriority().isEmpty()) {
      createWordInfo.setPriority("NOT_STATUS");
    }

    ReadWord readWord = wordService.add(createWordInfo.getWord());
    ReadTopic readTopic = topicService.add(createWordInfo.getTopic());
    ReadTranslate readTranslate = translateService.add(createWordInfo.getTranslate());

    createWordInfo.setCreateDate(LocalDate.now());
    createWordInfo.setLastRepeatDate(LocalDate.now());
    createWordInfo.setStatus("NEW");
    createWordInfo.setCountRepeat(0);

    SaveWordInfo saveWordInfo = wordInfoMapper.saveWordInfoFromCreateWordInfo(createWordInfo);
    saveWordInfo.setWord(readWord);
    saveWordInfo.setTopic(readTopic);
    saveWordInfo.setTranslate(readTranslate);
    WordInfo wordInfo = wordInfoRepo.save(wordInfoMapper.wordInfoFromSaveWordInfo(saveWordInfo));

    return wordInfoMapper.readWordInfoFromWordInfo(wordInfo);
  }

  @Transactional
  @Override
  public String delete(String string) {
    return null;
  }

  @Transactional
  @Override
  public ReadWordInfo update(ReadWordInfo readWordInfo) {
    return null;
  }
}
