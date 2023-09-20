package com.zakharau.controller.wordInfo;

import com.zakharau.dto.wordInfo.CreateWordInfo;
import com.zakharau.dto.wordInfo.ReadWordInfo;
import com.zakharau.service.WordInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WordInfoController implements WordInfoApi {

  private final WordInfoService wordInfoService;

  @Override
  public ReadWordInfo createWord(CreateWordInfo createWordInfo) {
    return wordInfoService.add(createWordInfo);
  }
}
