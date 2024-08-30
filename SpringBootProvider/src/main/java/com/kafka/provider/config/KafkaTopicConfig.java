package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic() {
        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // delete message | COMPACT still last message
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "8640000"); // time retentions of messages
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // 1GB size max of segment
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); // size max of message - default 1MB

        return TopicBuilder.name("unProgramadorNace-Topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
