package com.zakharau.repository;

import com.zakharau.entety.Word;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepo extends JpaRepository<Word, Long> {

  List<Word> findAllByWord(String word);

  void deleteWordByWord(String word);
}
