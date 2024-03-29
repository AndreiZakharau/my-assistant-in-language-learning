package com.zakharau.controller.word;

import com.zakharau.dto.word.CreateWord;
import com.zakharau.dto.word.ReadWord;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/words")
@Validated
public interface WordApi {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  ReadWord addWord(@Valid @RequestBody CreateWord viewDto);

}
