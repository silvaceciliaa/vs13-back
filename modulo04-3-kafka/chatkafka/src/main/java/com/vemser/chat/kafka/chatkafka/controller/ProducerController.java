package com.vemser.chat.kafka.chatkafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vemser.chat.kafka.chatkafka.dto.NomeChat;
import com.vemser.chat.kafka.chatkafka.kafka.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProducerController {
    private final Producer producer;

    @PostMapping("/send-to")
    public void sendTo(@RequestParam List<NomeChat> chats, @RequestParam String mensagem) throws JsonProcessingException {
        for (NomeChat nome : chats) {
            producer.sendTo(mensagem, nome);
        }
    }
}
