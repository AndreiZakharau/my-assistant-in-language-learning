package com.zakharau.service;

import com.zakharau.dto.translate.CreateTranslate;
import com.zakharau.dto.translate.ReadTranslate;
import com.zakharau.entety.Translate;

public interface TranslateService extends EntityService<ReadTranslate, CreateTranslate> {

  Translate getTranslateByTranslate(String translateWord);
}
