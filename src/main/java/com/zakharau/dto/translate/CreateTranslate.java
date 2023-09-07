package com.zakharau.dto.translate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTranslate {

  @Size(max = 1000, message = "Translate : size must be between 0 and 1000")
  @NotBlank(message = "Field translate shouldn't be empty, null, contain only whitespaces.")
  private String translate;
}
