package com.resiliencia.padroes.service;


import com.resiliencia.padroes.client.MagaluClient;
import com.resiliencia.padroes.client.MeliClient;
import com.resiliencia.padroes.domain.ProdutoSaleRecord;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class PrecoService {

    private final MagaluClient magaluClient;
    private final MeliClient meliClient;

    public PrecoService(MagaluClient magaluClient, MeliClient meliClient) {
        this.magaluClient = magaluClient;
        this.meliClient = meliClient;
    }

    @CircuitBreaker(name = "precoCB", fallbackMethod = "obterPrecosMeli")
    public ProdutoSaleRecord obterPreco(){

        System.out.println("obter precos magalu");

        return magaluClient.obterProduto();

    }

    public ProdutoSaleRecord obterPrecosMeli(Throwable throwable){

        System.out.println("Fallback acionado: " + throwable.getMessage());
        System.out.println("obter precos meli");

        return meliClient.obterProduto();

    }

}
