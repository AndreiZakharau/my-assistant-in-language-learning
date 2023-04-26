package com.zakharau.dto;

import com.zakharau.entety.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WordDto {

  private String word;
  private String translate;
  private Status status;

}
