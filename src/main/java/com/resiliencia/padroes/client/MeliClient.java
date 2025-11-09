package com.resiliencia.padroes.client;


import com.resiliencia.padroes.domain.ProdutoSaleRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "MeliClient",
        url = "http://localhost:8080",
        configuration = MeliConfigFeign.class
)
public interface MeliClient {

    @GetMapping("/meli/produto")
    public ProdutoSaleRecord obterProduto();

}
