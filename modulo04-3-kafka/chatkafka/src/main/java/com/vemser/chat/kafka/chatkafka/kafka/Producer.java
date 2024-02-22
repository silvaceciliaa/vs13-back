package com.vemser.chat.kafka.chatkafka.kafka;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.chat.kafka.chatkafka.dto.MensagemCreateDTO;
import com.vemser.chat.kafka.chatkafka.dto.MensagemDTO;
import com.vemser.chat.kafka.chatkafka.dto.NomeChat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic}")
    private String topic;
    private void send(MensagemDTO mensagemDTO, NomeChat nomeChat) throws JsonProcessingException {
        String payload = objectMapper.writeValueAsString(mensagemDTO);
        Message<String> message = MessageBuilder.withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .setHeader(KafkaHeaders.PARTITION_ID, nomeChat.ordinal())
                .build();
        ListenableFuture<SendResult<String, String>> send = stringKafkaTemplate.send(message);
        send.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Erro ao enviar mensagem!");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("{} [{}] para {}: {}",
                        mensagemDTO.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                        mensagemDTO.getUsuario(),
                        nomeChat,
                        mensagemDTO.getMensagem());
            }
        });
    }

    public void sendToChatGeral(MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        mensagemDTO.setUsuario(NomeChat.CECÍLIA_SILVA.name());
        send(mensagemDTO, NomeChat.AA_GERAL);
    }

    public void sendTo(String mensagem, NomeChat nomeChat) throws JsonProcessingException {
        MensagemDTO mensagemDTO = new MensagemDTO();
        mensagemDTO.setMensagem(mensagem);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        mensagemDTO.setUsuario(NomeChat.CECÍLIA_SILVA.name());
        send(mensagemDTO, nomeChat);
    }
}
