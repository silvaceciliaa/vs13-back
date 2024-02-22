package com.vemser.chat.kafka.chatkafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemCreateDTO {
    private String mensagem;
}