package com.zakharau.dto.word;

import java.util.Set;
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
public class ViewWordDto {

  private String word;
  private Set<String> liseTranslate;
  private Set<String> listTopic;

}
