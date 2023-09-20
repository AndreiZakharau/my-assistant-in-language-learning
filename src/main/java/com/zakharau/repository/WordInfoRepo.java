package com.zakharau.repository;

import com.zakharau.entety.WordInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordInfoRepo extends JpaRepository<WordInfo, Long> {

}
