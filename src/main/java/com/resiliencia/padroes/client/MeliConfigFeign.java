package com.resiliencia.padroes.client;


import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MeliConfigFeign {

    @Bean(name = "meliOption")
    public Request.Options requestOption(){
        return new Request.Options(2000, 2000);
    }

}
