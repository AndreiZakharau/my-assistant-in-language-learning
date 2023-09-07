package com.zakharau.dto.word;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class CreateWord {

  @Size(max = 1000, message = "word : size must be between 0 and 1000")
  @NotBlank(message = "Field word shouldn't be empty, null, contain only whitespaces.")
  private String word;

}
