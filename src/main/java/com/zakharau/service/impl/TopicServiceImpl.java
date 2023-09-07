package com.zakharau.service.impl;

import com.zakharau.dto.topic.CreateTopic;
import com.zakharau.dto.topic.ReadTopic;
import com.zakharau.entety.Topic;
import com.zakharau.mapper.TopicMapper;
import com.zakharau.repository.TopicRepo;
import com.zakharau.service.TopicService;
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

    if (getTopicByTopicName(createTopic.getTopicName())==null) {
      return mapper.readTopicFromTopic(repository.save(mapper.topicFromCreateTopic(createTopic)));
    }else {
      throw new RuntimeException("This topic is present."); //ToDo rename exception
    }
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
