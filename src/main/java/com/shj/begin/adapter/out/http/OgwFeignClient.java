package com.shj.begin.adapter.out.http;

import com.shj.begin.domain.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "externalApi", url = "${external-api.base-url}")
public interface OgwFeignClient {

    @PostMapping("/v1/users")
    ResponseEntity<Void> send(Person person);

}

