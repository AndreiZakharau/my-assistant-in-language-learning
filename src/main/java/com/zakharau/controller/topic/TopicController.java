package com.zakharau.controller.topic;

import com.zakharau.dto.topic.CreateTopic;
import com.zakharau.dto.topic.ReadTopic;
import com.zakharau.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TopicController implements TopicApi{

  private final TopicService service;

  @Override
  public ReadTopic addTopic(CreateTopic createTopicDto) {
    return service.add(createTopicDto);
  }
}
