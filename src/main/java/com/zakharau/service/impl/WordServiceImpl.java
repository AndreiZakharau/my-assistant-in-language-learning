package com.zakharau.service.impl;

import com.zakharau.dto.WordDto;
import com.zakharau.service.WordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WordServiceImpl implements WordService {

  @Override
  @Transactional
  public String add(WordDto wordDto) {
    return null;
  }

  @Override
  @Transactional
  public String delete(WordDto wordDto) {
    return null;
  }

  @Override
  @Transactional
  public WordDto update(WordDto wordDto) {
    return null;
  }
}
