package com.zakharau.mapper;

import static com.zakharau.mapper.TopicMapper.TOPIC_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.zakharau.dto.topic.TopicDto.TopicDto;
import com.zakharau.entety.Topic;
import com.zakharau.testobject.EntetyObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TopicMapperTest {

  @Test
  void createToTopicDtoFromTopic() {

    Topic topic = EntetyObject.getTopic();

    TopicDto dto = TOPIC_MAPPER.toTopicDto(topic);

    assertNotNull(dto);
    assertEquals(dto.getTopic(), topic.getTopicName());
    assertNotEquals(dto.getId(), 3);
  }

  @Test
  void createToTopicFromTopicDto() {

    TopicDto dto = EntetyObject.getTopicDto();

    Topic topic = TOPIC_MAPPER.toTopic(dto);

    assertNotNull(topic);
    assertEquals(topic.getTopicName(), dto.getTopic());
    assertNotEquals(topic.getId(), 3);
  }
}