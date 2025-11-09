package com.resiliencia.padroes.controller;

import com.resiliencia.padroes.domain.ProdutoRecord;
import com.resiliencia.padroes.service.DelayTracker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class MeliController {

    private final DelayTracker delayTracker;

    public MeliController(DelayTracker delayTracker) {
        this.delayTracker = delayTracker;
    }

    @GetMapping("/meli/produto")
    public ResponseEntity<ProdutoRecord> obter(){

        delayTracker.applyDelay();

        return ResponseEntity.ok(
                new ProdutoRecord("1", "Lego Game Boy", BigDecimal.TEN, "Meli"));

    }

}
