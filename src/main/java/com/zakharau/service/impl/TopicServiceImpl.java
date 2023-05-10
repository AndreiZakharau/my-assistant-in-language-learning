package com.zakharau.service.impl;

import com.zakharau.dto.topic.TopicDto.TopicDto;
import com.zakharau.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

  @Override
  @Transactional
  public TopicDto add(TopicDto topicDto) {
    return null;
  }

  @Override
  @Transactional
  public String delete(TopicDto topicDto) {
    return null;
  }

  @Override
  @Transactional
  public TopicDto update(TopicDto topicDto) {
    return null;
  }
}
