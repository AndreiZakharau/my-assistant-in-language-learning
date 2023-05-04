package com.zakharau.mapper;

import com.zakharau.dto.translate.TranslateDto.TranslateDto;
import com.zakharau.entety.Translate;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TranslateMapper {

  TranslateMapper TRANSLATE_MAPPER = Mappers.getMapper(TranslateMapper.class);

  TranslateDto toTranslateDto(Translate translate);

  @InheritInverseConfiguration
  @Mapping(target = "wordList", ignore = true)
  Translate toTranslate(TranslateDto translateDto);
}
