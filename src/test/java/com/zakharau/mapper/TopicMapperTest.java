package com.zakharau.mapper;

import static com.zakharau.mapper.TopicMapper.TOPIC_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.zakharau.dto.topic.TopicDto.TopicDto;
import com.zakharau.entety.Topic;
import com.zakharau.entety.Word;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TopicMapperTest {

  @Test
  void createToTopicDtoFromTopic() {

    Topic topic = Topic.builder()
        .id(1L)
        .topicName("all")
        .words(Set.of(new Word()))
        .build();

    TopicDto dto = TOPIC_MAPPER.toTopicDto(topic);

    assertNotNull(dto);
    assertEquals(dto.getTopic(), topic.getTopicName());
    assertNotEquals(dto.getId(), 3);
  }

  @Test
  void createToTopicFromTopicDto() {

    TopicDto dto = TopicDto.builder()
        .id(1L)
        .topic("all")
        .build();

    Topic topic = TOPIC_MAPPER.toTopic(dto);

    assertNotNull(topic);
    assertEquals(topic.getTopicName(), dto.getTopic());
    assertNotEquals(topic.getId(), 3);
  }
}