package br.com.feltex.whatsapbot.controller;

import br.com.feltex.whatsapbot.modelo.Mensagem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Set;

class EnviaMensagemTest {
    private TestRestTemplate restTemplate = new TestRestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String URL = "http://localhost:8080/zap-zap";

    @Test
    void enviarMensagem() throws Exception {
        var mensagem = new Mensagem();
        mensagem.setContatos(Set.of("Dad"));
        mensagem.setConteudo("Este robô envia mensagens automatica para o ZAP ZAP");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpRequest = new HttpEntity<>(objectMapper.writeValueAsString(mensagem), httpHeaders);
        restTemplate.postForEntity(URL, httpRequest, String.class).getStatusCode();
    }
}