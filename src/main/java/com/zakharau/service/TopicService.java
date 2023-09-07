package com.zakharau.service;

import com.zakharau.dto.topic.CreateTopic;
import com.zakharau.dto.topic.ReadTopic;
import com.zakharau.entety.Topic;

public interface TopicService extends EntityService<ReadTopic, CreateTopic> {

  Topic getTopicByTopicName(String topicName);

}
