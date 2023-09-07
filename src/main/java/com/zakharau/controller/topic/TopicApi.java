package com.zakharau.controller.topic;

import com.zakharau.dto.topic.CreateTopic;
import com.zakharau.dto.topic.ReadTopic;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/topics")
@Validated
public interface TopicApi {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  ReadTopic addTopic(@Valid @RequestBody CreateTopic createTopicDto);
}
