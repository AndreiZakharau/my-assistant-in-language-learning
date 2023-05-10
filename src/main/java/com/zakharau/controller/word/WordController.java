package com.zakharau.controller.word;

import com.zakharau.dto.word.ViewWordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WordController implements WordApi {



  @Override
  public ResponseEntity<String> addWord(ViewWordDto viewDto) {
    return null;
  }
}
