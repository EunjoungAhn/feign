package dev.be.feign.service;

import dev.be.feign.common.dto.BaseRequestInfo;
import dev.be.feign.common.dto.BaseResponseInfo;
import dev.be.feign.feign.client.DemoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final DemoFeignClient demoFeignClient;

    public String get(){
        ResponseEntity<BaseResponseInfo> response = demoFeignClient.callGet("CustomHeader", "CustomName", 1L);
        //제대로 들어왔는지 확인하기
        System.out.println("Name: " + response.getBody().getName());
        System.out.println("Age: " + response.getBody().getAge());
        System.out.println("Header: " + response.getBody().getHeader());
        return "get";
    }
}
