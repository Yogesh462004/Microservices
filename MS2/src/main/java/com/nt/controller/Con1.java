package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.FeignClienC;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RefreshScope
@RequestMapping("/get")
public class Con1 {
	@Value("${dbuser}")
    private String user;
	@Value("${dbpassword}")
	private Integer pwd;
    @Autowired
    private FeignClienC c;
    
    public static final String userservice="MS2";
    @CircuitBreaker(name=userservice,fallbackMethod="dummy")
    @GetMapping("/go")
    public ResponseEntity<String> gett() {
        String s = c.fget(); // calling Feign client
        return ResponseEntity.ok("Bill Amount:1077: " + s+"::::"+user+"---"+pwd);
    }
    public ResponseEntity<String> dummy(Throwable t) {
        return ResponseEntity.ok("Come Tomorrow or wait For some time");
    }    
}
