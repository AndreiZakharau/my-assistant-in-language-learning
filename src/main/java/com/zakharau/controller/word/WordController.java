package com.zakharau.controller.word;

import com.zakharau.dto.word.CreateWord;
import com.zakharau.dto.word.ReadWord;
import com.zakharau.service.impl.WordServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WordController implements WordApi {

  private final WordServiceImpl wordService;

  @Override
  public ReadWord addWord(CreateWord createWord) {
    return wordService.add(createWord);
  }
}
