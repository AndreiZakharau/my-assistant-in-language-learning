package com.zakharau.mapper;

import com.zakharau.dto.word.CreateWord;
import com.zakharau.dto.word.ReadWord;
import com.zakharau.entety.Word;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WordMapper {

  WordMapper WORD_MAPPER = Mappers.getMapper(WordMapper.class);

//  @Mapping(target = "translateList", source = "translates")
//  @Mapping(target = "topicList", source = "topics")
//  WordDto toWordDto(Word word);

//  @InheritInverseConfiguration
//  Word toWord(WordDto wordDto);

//  @Mapping(target = "listTranslate", source = "translates")
//  @Mapping(target = "listTopic", source = "topics")
//  CreateWord createWordFromWord(Word word);

//  @InheritInverseConfiguration
  Word wordFromCreateWord(CreateWord createWord);
  ReadWord readWordFromWord(Word word);
  Word wordFromReadWord(ReadWord readWord);

//  @Mapping(target = "listTranslate", source = "translateList")
//  @Mapping(target = "listTopic", source = "topicList")
//  CreateWord createWordDtoFromWordDto(WordDto wordDto);

//  @InheritInverseConfiguration
//  WordDto wordDtoFromViewWordDto(CreateWord createWord);


}
