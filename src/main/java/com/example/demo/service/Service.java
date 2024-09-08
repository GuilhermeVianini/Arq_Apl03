package com.example.demo.service;
import org.springframework.http.RequestEntity;

import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;
public class Service {
    public String preverTempo(){
        String dadosMeteorologicos = "";
        String apiUrl = "http://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=8ec477ef76f98ecb1be2c5ecd824a4b2";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl,String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()){
            dadosMeteorologicos= responseEntity.getBody();
        }else{
            dadosMeteorologicos= "Falha ao obter dados meteorologicos. Codigo de status: " + responseEntity.getStatusCode();
        }
        return dadosMeteorologicos;

    }
}

