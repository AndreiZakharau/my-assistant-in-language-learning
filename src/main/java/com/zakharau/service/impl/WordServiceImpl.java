package com.zakharau.service.impl;

import com.zakharau.dto.word.WordDto;
import com.zakharau.entety.Status;
import com.zakharau.entety.Word;
import com.zakharau.mapper.WordMapper;
import com.zakharau.repository.WordRepo;
import com.zakharau.service.WordService;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
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

    return wordMapper.toWordDto(wordRepo.save(word));
  }

  @Override
  @Transactional
  public String delete(String word) {

    if (!getAllWordByWord(word).isEmpty()) {
      wordRepo.deleteWordByWord(word);
      return "Word " + word + " was deleted";
    } else {
      throw new EntityNotFoundException(String.format("Incorrect word: %s", word));
    }
  }

  @Override
  @Transactional
  public WordDto update(WordDto wordDto) {

    if (!getAllWordByWord(wordDto.getWord()).isEmpty()) {
      Word word = wordRepo.saveAndFlush(wordMapper.toWord(wordDto));
      return wordMapper.toWordDto(word);
    } else {
      throw new EntityNotFoundException(String.format("Incorrect word: %s", wordDto.getWord()));
    }
  }

  @Transactional
  public List<Word> getAllWordByWord(String word) {
    return wordRepo.findAllByWord(word);
  }
}
