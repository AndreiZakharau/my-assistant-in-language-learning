package com.zakharau.mapper;

import com.zakharau.dto.topic.CreateTopic;
import com.zakharau.dto.topic.ReadTopic;
//import com.zakharau.dto.topic.TopicDto;
import com.zakharau.entety.Topic;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TopicMapper {

  TopicMapper TOPIC_MAPPER = Mappers.getMapper(TopicMapper.class);

//  @Mapping(target = "topic", source = "topicName")
//  TopicDto toTopicDto(Topic topic);
//  @InheritInverseConfiguration
//  @Mapping(target = "words", ignore = true)
//  Topic toTopic(TopicDto topicDto);

  Topic topicFromCreateTopic(CreateTopic createTopic);

  Topic topicFromReadTopic(ReadTopic readTopic);
  ReadTopic readTopicFromTopic(Topic topic);

//  CreateTopic createTopicFromReadTopicDto(ReadTopic readTopic);
//  CreateTopicDto createTopicDtoFromTopic(Topic topic);
//  @Mapping(target = "topicName", source = "topic")
//  ReadTopic readTopicDtoFromTopicDto(TopicDto topicDto);
}
