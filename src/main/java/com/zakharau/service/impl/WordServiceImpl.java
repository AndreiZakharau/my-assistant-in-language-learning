package com.zakharau.service.impl;

import com.zakharau.dto.word.WordDto;
import com.zakharau.mapper.WordMapper;
import com.zakharau.repository.WordRepo;
import com.zakharau.service.WordService;
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
  public String add(WordDto wordDto) {

    return "Word %s is added" + wordDto.getWord();
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
