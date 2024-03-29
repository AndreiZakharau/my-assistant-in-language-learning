package com.zakharau.repository;

import com.zakharau.entety.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepo extends JpaRepository<Topic, Long> {

  Topic getTopicByTopicName(String topicName);
}
