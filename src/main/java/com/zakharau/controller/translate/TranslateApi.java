package com.zakharau.controller.translate;

import com.zakharau.dto.translate.CreateTranslate;
import com.zakharau.dto.translate.ReadTranslate;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/translates")
@Validated
public interface TranslateApi {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  ReadTranslate addTranslate(@Valid @RequestBody CreateTranslate createTranslate);
}
