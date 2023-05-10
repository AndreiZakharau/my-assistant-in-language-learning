package com.zakharau.controller.word;

import com.zakharau.dto.word.ViewWordDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/word")
@Validated
public interface WordApi {

  @PostMapping
  ResponseEntity<String> addWord(@RequestBody ViewWordDto viewDto);

}
