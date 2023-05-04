package com.zakharau.service.impl;

import com.zakharau.dto.word.ViewWordDto;
import com.zakharau.service.WordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WordServiceImpl implements WordService {

  @Override
  @Transactional
  public String add(ViewWordDto wordDto) {
    return null;
  }

  @Override
  @Transactional
  public String delete(ViewWordDto wordDto) {
    return null;
  }

  @Override
  @Transactional
  public ViewWordDto update(ViewWordDto wordDto) {
    return null;
  }
}
