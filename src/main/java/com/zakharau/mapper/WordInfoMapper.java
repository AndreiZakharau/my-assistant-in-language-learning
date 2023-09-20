package com.zakharau.mapper;

import com.zakharau.dto.wordInfo.CreateWordInfo;
import com.zakharau.dto.wordInfo.ReadWordInfo;
import com.zakharau.dto.wordInfo.SaveWordInfo;
import com.zakharau.entety.WordInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WordInfoMapper {

  WordInfoMapper WORD_INFO_MAPPER = Mappers.getMapper(WordInfoMapper.class);

  WordInfo wordInfoFromCreateWordInfo(CreateWordInfo createWordInfo);

  WordInfo wordInfoFromReadWordInfo(ReadWordInfo readWordInfo);
  WordInfo wordInfoFromSaveWordInfo(SaveWordInfo saveWordInfo);

  ReadWordInfo readWordInfoFromWordInfo(WordInfo wordInfo);

  SaveWordInfo saveWordInfoFromCreateWordInfo(CreateWordInfo createWordInfo);
}
