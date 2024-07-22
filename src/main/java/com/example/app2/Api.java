package com.example.app2;

import ch.qos.logback.core.util.StringUtil;
import com.example.app2.exception.NotFoundException;
import com.example.app2.exception.TxException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/app2")
public class Api {
    @Value("${dns.app1}")
    private String dnsApp1;

    private final BaseRest baseRest;

    @GetMapping("/health-check")
    public void health(){
        return;
    }

    @GetMapping("/test")
    public String get(){

        if (StringUtil.isNullOrEmpty(dnsApp1)){
            return "dns null or empty";
        }

        var responseEntity = baseRest.getForEntity(dnsApp1 + "/health-check", String.class);

        if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
//            log.error(String.format("No movie is found with Id %s", Id));
//            throw new NotFoundException(String.format("No movie is found with Id %s", Id));
        } else if (responseEntity.getStatusCode() != HttpStatus.OK) {
            log.error("An error occurred while processing your request");
            throw new TxException("An error occurred while processing your request");
        }

        return "gateway: " + responseEntity.getBody();

    }

}
