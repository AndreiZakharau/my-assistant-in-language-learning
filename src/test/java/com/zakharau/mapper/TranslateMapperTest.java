package com.zakharau.mapper;

import static com.zakharau.mapper.TranslateMapper.TRANSLATE_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.zakharau.dto.translate.TranslateDto.TranslateDto;
import com.zakharau.entety.Translate;
import com.zakharau.entety.Word;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TranslateMapperTest {

  @Test
  void createToTranslateDtoFromTranslate() {

    Translate translate = Translate.builder()
        .id(2L)
        .translate("стоп")
        .wordList(Set.of(new Word()))
        .build();

    TranslateDto dto = TRANSLATE_MAPPER.toTranslateDto(translate);

    assertNotNull(dto);
    assertNotEquals(dto.getTranslate(), "старт");
    assertEquals(dto.getTranslate(), translate.getTranslate());
  }

  @Test
  void createToTranslateFromTranslateDto() {

    TranslateDto translateDto = TranslateDto.builder()
        .id(2L)
        .translate("стоп")
        .build();

    Translate translate = TRANSLATE_MAPPER.toTranslate(translateDto);

    assertNotNull(translate);
    assertEquals(translate.getTranslate(), translateDto.getTranslate());
    assertNotEquals(translate.getTranslate(), "старт");
  }
}