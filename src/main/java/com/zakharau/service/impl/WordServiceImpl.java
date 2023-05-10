package com.zakharau.service.impl;

import com.zakharau.dto.word.WordDto;
import com.zakharau.entety.Status;
import com.zakharau.entety.Word;
import com.zakharau.mapper.WordMapper;
import com.zakharau.repository.WordRepo;
import com.zakharau.service.WordService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {

  private final WordRepo wordRepo;
  private final WordMapper wordMapper;

  @Override
  @Transactional
  public WordDto add(WordDto wordDto) {

    wordDto.setStatus(String.valueOf(Status.NEW));
    wordDto.setCreateDate(LocalDate.now());
    wordDto.setLastRepeatDate(LocalDate.now());
    wordDto.setCountRepeat(0);
    Word word = wordMapper.toWord(wordDto);
    Word saveWord = wordRepo.save(word);

    return wordMapper.toWordDto(saveWord);
  }

  @Override
  @Transactional
  public String delete(WordDto wordDto) {
    return "Word %s was deleted";
  }

  @Override
  @Transactional
  public WordDto update(WordDto wordDto) {
    return wordDto;
  }
}
