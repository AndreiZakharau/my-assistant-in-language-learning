package com.zakharau.controller.wordInfo;

import com.zakharau.dto.wordInfo.CreateWordInfo;
import com.zakharau.dto.wordInfo.ReadWordInfo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/wordInfos")
@Validated
public interface WordInfoApi {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  ReadWordInfo createWord(@Valid @RequestBody CreateWordInfo createWordInfo);

}
