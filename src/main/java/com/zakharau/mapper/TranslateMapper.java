package com.zakharau.mapper;

import com.zakharau.dto.translate.CreateTranslate;
import com.zakharau.dto.translate.ReadTranslate;
import com.zakharau.entety.Translate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TranslateMapper {

  TranslateMapper TRANSLATE_MAPPER = Mappers.getMapper(TranslateMapper.class);

//  TranslateDto toTranslateDto(Translate translate);

//  @InheritInverseConfiguration
//  @Mapping(target = "wordList", ignore = true)
//  Translate toTranslate(TranslateDto translateDto);

  Translate translateFromCreateTranslate(CreateTranslate createTranslate);
  ReadTranslate readTranslateFromTranslate(Translate translate);

  Translate translateFromReadTranslate(ReadTranslate readTranslate);

//  ReadTranslate readTranslateFromTranslateDto(TranslateDto translateDto);
}
