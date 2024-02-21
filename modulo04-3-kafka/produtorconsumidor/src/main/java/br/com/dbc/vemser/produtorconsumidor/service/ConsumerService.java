package br.com.dbc.vemser.produtorconsumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "meu-primeiro-topico", // meu-primeiro-topico
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "primeiroTopico")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, message);
    }

    @KafkaListener(
            groupId = "group2",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "segundoTopico",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"1", "2"})}
    )
    public void consumirParticao(@Payload String message,
                         @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                         @Header(KafkaHeaders.OFFSET) Long offset,
                         @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
                         @Header(KafkaHeaders.RECEIVED_TOPIC) String topic
    ) throws JsonProcessingException {
        log.info("#### offset -> '{}' key -> '{}' -> Partition -> '{}' Topic -> '{}' msg -> '{}'   ", offset, key, partitionId, topic, message);
    }
}
