package com.zakharau.dto.topic;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTopic {

  @Size(max = 100, message = "topicName : size must be between 0 and 100")
  @NotNull(message = "Field topic shouldn't be empty, null, contain only whitespaces and letters.")
  private String topicName;
}
