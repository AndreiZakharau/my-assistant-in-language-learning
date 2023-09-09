package com.zakharau.service.impl;

import com.zakharau.dto.word.CreateWord;
import com.zakharau.dto.word.ReadWord;
import com.zakharau.entety.Word;
import com.zakharau.mapper.WordMapper;
import com.zakharau.repository.WordRepo;
import com.zakharau.service.WordService;
import jakarta.persistence.EntityNotFoundException;
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
  public ReadWord add(CreateWord createWord) {

    if (getWordByWord(createWord.getWord()) != null) {
      throw new RuntimeException(String.format("This word %s is present", createWord.getWord()));
    } else {
      Word word = wordRepo.save(wordMapper.wordFromCreateWord(createWord));
      return wordMapper.readWordFromWord(word);
    }

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
  public ReadWord update(ReadWord readWord) {

    if (!getAllWordByWord(readWord.getWord()).isEmpty()) {
      Word word = wordRepo.saveAndFlush(wordMapper.wordFromReadWord(readWord));
      return wordMapper.readWordFromWord(word);
    } else {
      throw new EntityNotFoundException(String.format("Incorrect word: %s", readWord.getWord()));
    }
  }

  @Transactional
  public List<Word> getAllWordByWord(String word) {
    return wordRepo.findAllByWord(word);
  }

  @Override
  @Transactional(readOnly = true)
  public Word getWordByWord(String word) {
    return wordRepo.getWordByWord(word);
  }
}
