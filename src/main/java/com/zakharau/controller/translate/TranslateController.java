package com.zakharau.controller.translate;


import com.zakharau.dto.translate.CreateTranslate;
import com.zakharau.dto.translate.ReadTranslate;
import com.zakharau.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TranslateController implements TranslateApi{

  private final TranslateService service;

  @Override
  public ReadTranslate addTranslate(CreateTranslate createTranslate) {
    return service.add(createTranslate);
  }
}
