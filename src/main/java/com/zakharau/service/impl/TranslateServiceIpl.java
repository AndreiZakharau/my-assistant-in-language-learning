package com.zakharau.service.impl;

import com.zakharau.dto.translate.CreateTranslate;
import com.zakharau.dto.translate.ReadTranslate;
import com.zakharau.entety.Translate;
import com.zakharau.mapper.TranslateMapper;
import com.zakharau.repository.TranslateRepo;
import com.zakharau.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TranslateServiceIpl implements TranslateService {

  private final TranslateRepo repository;
  private final TranslateMapper mapper;

  @Override
  @Transactional
  public ReadTranslate add(CreateTranslate createTranslate) {

    if (getTranslateByTranslate(createTranslate.getTranslate())==null) {
      return mapper.readTranslateFromTranslate(repository.save(mapper.translateFromCreateTranslate(createTranslate)));
    }
    throw new RuntimeException("This translate is present.");
  }

  @Override
  @Transactional
  public String delete(String string) {
    return null;
  }

  @Override
  @Transactional
  public ReadTranslate update(ReadTranslate readTranslate) {
    return null;
  }

  @Override
  @Transactional(readOnly = true)
  public Translate getTranslateByTranslate(String translateWord) {
     return repository.getTranslateByTranslate(translateWord);
  }
}
