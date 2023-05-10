package com.zakharau.dto.word;

import com.zakharau.entety.Priority;
import com.zakharau.entety.Topic;
import com.zakharau.entety.Translate;
import java.util.List;
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
  private List<Translate> listTranslate;
  private List<Topic> listTopic;
  private Priority priority;

}
