package com.resiliencia.padroes.service;


import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DelayTracker {

    //Definir atraso no retorno
    private final Duration atraso = Duration.ofSeconds(10);

    //Definir Contadaor
    private final AtomicInteger contador = new AtomicInteger(0);


    public void applyDelay(){
        try {

            int total = contador.incrementAndGet();

            if(total > 3 ){
                return;
            }
            TimeUnit.MILLISECONDS.sleep(atraso.toMillis());
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }

}
