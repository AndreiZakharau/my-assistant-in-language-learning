package com.zakharau.service;

import com.zakharau.dto.word.CreateWord;
import com.zakharau.dto.word.ReadWord;
import com.zakharau.entety.Word;
import org.springframework.transaction.annotation.Transactional;

public interface WordService extends EntityService<ReadWord, CreateWord>{

  Word getWordByWord(String word);
}
