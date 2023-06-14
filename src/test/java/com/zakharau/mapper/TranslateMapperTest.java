package com.zakharau.mapper;

import static com.zakharau.mapper.TranslateMapper.TRANSLATE_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.zakharau.dto.translate.TranslateDto.TranslateDto;
import com.zakharau.entety.Translate;
import com.zakharau.testobject.EntetyObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TranslateMapperTest {

  @Test
  void createToTranslateDtoFromTranslate() {

    Translate translate = EntetyObject.getTranslate();

    TranslateDto dto = TRANSLATE_MAPPER.toTranslateDto(translate);

    assertNotNull(dto);
    assertNotEquals(dto.getTranslate(), "старт");
    assertEquals(dto.getTranslate(), translate.getTranslate());
  }

  @Test
  void createToTranslateFromTranslateDto() {

    TranslateDto translateDto = EntetyObject.getTranslateDto();

    Translate translate = TRANSLATE_MAPPER.toTranslate(translateDto);

    assertNotNull(translate);
    assertEquals(translate.getTranslate(), translateDto.getTranslate());
    assertNotEquals(translate.getTranslate(), "старт");
  }
}