package com.zakharau.repository;

import com.zakharau.dto.translate.TranslateDto.TranslateDto;
import com.zakharau.entety.Translate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslateRepo extends JpaRepository<Translate, Long> {

}
