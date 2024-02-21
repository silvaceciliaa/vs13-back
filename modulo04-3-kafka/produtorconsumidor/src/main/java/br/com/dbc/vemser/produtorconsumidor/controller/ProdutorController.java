package br.com.dbc.vemser.produtorconsumidor.controller;

import br.com.dbc.vemser.produtorconsumidor.service.ProdutorService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    public void enviar(String mensagem) {
        produtorService.enviarMensagem(mensagem);
    }

}

