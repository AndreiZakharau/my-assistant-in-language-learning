package com.zakharau.mapper;

import static com.zakharau.mapper.TopicMapper.TOPIC_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.zakharau.dto.topic.CreateTopic;
import com.zakharau.dto.topic.ReadTopic;
import com.zakharau.entety.Topic;
import com.zakharau.testobject.EntetyObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TopicMapperTest {

  private final Topic topic = EntetyObject.getTopic();
  private final ReadTopic readTopic = EntetyObject.getReadTopic();
  private final CreateTopic createTopic = EntetyObject.getCreateTopic();

  @Test
  void topicFromCreateTopic() {

    Topic newTopic = TOPIC_MAPPER.topicFromCreateTopic(createTopic);

    assertNotNull(newTopic);
    assertEquals(newTopic.getTopicName(),createTopic.getTopicName());
    assertNull(newTopic.getId());
  }

  @Test
  void topicFromReadTopic() {

    Topic newTopic = TOPIC_MAPPER.topicFromReadTopic(readTopic);

    assertNotNull(newTopic);
    assertEquals(newTopic.getTopicName(),readTopic.getTopicName());
    assertEquals(newTopic.getId(),readTopic.getId());
  }

  @Test
  void readTopicFromTopic() {

    ReadTopic dto = TOPIC_MAPPER.readTopicFromTopic(topic);

    assertNotNull(dto);
    assertEquals(dto.getTopicName(),topic.getTopicName());
    assertEquals(dto.getId(),topic.getId());
  }
}