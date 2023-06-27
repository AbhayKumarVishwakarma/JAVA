package com.abd.controller;

import com.abd.model.Request;
import com.abd.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/abd")
public class AppController {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/chat")
    public List<String> chat(@RequestParam("prompt") String prompt){
        Request request = new Request(model, prompt);
        Response response = restTemplate.postForObject(url, request, Response.class);
        return response.getChoiceList();
    }
}
