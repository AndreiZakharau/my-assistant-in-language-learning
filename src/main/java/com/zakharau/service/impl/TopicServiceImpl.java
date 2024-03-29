package com.zakharau.service.impl;

import com.zakharau.dto.topic.CreateTopic;
import com.zakharau.dto.topic.ReadTopic;
import com.zakharau.entety.Topic;
import com.zakharau.mapper.TopicMapper;
import com.zakharau.repository.TopicRepo;
import com.zakharau.service.TopicService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

  private final TopicMapper mapper;
  private final TopicRepo repository;

  @Override
  @Transactional
  public ReadTopic add(CreateTopic createTopic) {

    Topic topicName = getTopicByTopicName(createTopic.getTopicName());
    return mapper.readTopicFromTopic(Objects.requireNonNullElseGet(topicName,
        () -> repository.save(mapper.topicFromCreateTopic(createTopic))));
  }

  @Override
  @Transactional
  public String delete(String topicName) {
    return null;
  }

  @Override
  @Transactional
  public ReadTopic update(ReadTopic topicDto) {
    return null;
  }

  @Override
  @Transactional(readOnly = true)
  public Topic getTopicByTopicName(String topicName) {

    return repository.getTopicByTopicName(topicName);
  }

}
