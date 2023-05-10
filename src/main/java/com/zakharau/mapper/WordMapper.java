package com.zakharau.mapper;

import com.zakharau.dto.word.ViewWordDto;
import com.zakharau.dto.word.WordDto;
import com.zakharau.entety.Word;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WordMapper {

  WordMapper WORD_MAPPER = Mappers.getMapper(WordMapper.class);

  @Mapping(target = "translateList", source = "translates")
  @Mapping(target = "topicList", source = "topics")
  WordDto toWordDto(Word word);

  @InheritInverseConfiguration
  Word toWord(WordDto wordDto);

  @Mapping(target = "listTranslate", source = "translates")
  @Mapping(target = "listTopic", source = "topics")
  ViewWordDto toViewWordDto(Word word);

  @InheritInverseConfiguration
  Word wordFromViewWordDto(ViewWordDto viewWordDto);

  @Mapping(target = "listTranslate", source = "translateList")
  @Mapping(target = "listTopic", source = "topicList")
  ViewWordDto viewWordDtoFromWordDto(WordDto wordDto);

  @InheritInverseConfiguration
  WordDto wordDtoFromViewWordDto(ViewWordDto viewWordDto);




}
