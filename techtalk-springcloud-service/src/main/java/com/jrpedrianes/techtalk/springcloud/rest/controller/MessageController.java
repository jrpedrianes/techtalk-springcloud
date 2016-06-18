package com.jrpedrianes.techtalk.springcloud.rest.controller;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jrpedrianes.techtalk.springcloud.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RequestMapping("/messages")
@RestController
public class MessageController {

    @Autowired
    private ApplicationProperties applicationProperties;

    @RequestMapping(method = GET)
    public HttpEntity<List<Map<String, String>>> findAllMessages() {
        Map<String, String> map = new HashMap<>();
        map.put("text", applicationProperties.getMessage());
        return ok(Collections.singletonList(map));
    }
}
