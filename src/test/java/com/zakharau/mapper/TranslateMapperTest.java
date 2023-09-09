package com.zakharau.mapper;

import static com.zakharau.mapper.TranslateMapper.TRANSLATE_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.zakharau.dto.translate.CreateTranslate;
import com.zakharau.dto.translate.ReadTranslate;
import com.zakharau.entety.Translate;
import com.zakharau.testobject.EntetyObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TranslateMapperTest {

  private final Translate translate = EntetyObject.getTranslate();
  private final CreateTranslate createTranslate = EntetyObject.getCreateTranslate();
  private final ReadTranslate readTranslate = EntetyObject.getReadTranslate();

  @Test
  void  translateFromCreateTranslate() {

    Translate newTranslate = TRANSLATE_MAPPER.translateFromCreateTranslate(createTranslate);

    assertNotNull(newTranslate);
    assertEquals(newTranslate.getTranslate(),createTranslate.getTranslate());
    assertNull(newTranslate.getId());
  }
  @Test
  void translateFromReadTranslate() {

    Translate newTranslate = TRANSLATE_MAPPER.translateFromReadTranslate(readTranslate);

    assertNotNull(newTranslate);
    assertEquals(newTranslate.getTranslate(),readTranslate.getTranslate());
    assertEquals(newTranslate.getId(),readTranslate.getId());
  }
  @Test
  void readTranslateFromTranslate() {

    ReadTranslate dto = TRANSLATE_MAPPER.readTranslateFromTranslate(translate);

    assertNotNull(dto);
    assertEquals(dto.getTranslate(),translate.getTranslate());
    assertEquals(dto.getId(),translate.getId());
  }
}