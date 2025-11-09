package com.resiliencia.padroes.service;


import com.resiliencia.padroes.client.MagaluClient;
import org.springframework.stereotype.Service;

@Service
public class PrecoService {

    private final MagaluClient magaluClient;

    public PrecoService(MagaluClient magaluClient) {
        this.magaluClient = magaluClient;
    }

    public void obterPreco(){

        magaluClient.obterProduto();

    }

}
