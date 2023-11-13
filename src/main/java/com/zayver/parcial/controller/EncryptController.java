package com.zayver.parcial.controller;

import com.zayver.parcial.bridge.encrypt.IEncrypt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/bridge")
@Slf4j
public class EncryptController {
    @Autowired
    private IEncrypt iEncrypt;

    @PostMapping
    public Map<String, String> encryptMessage(@RequestBody Map<String, String> req){
        String res;
        try {
            res = iEncrypt.encrypt(req.get("message"), req.get("password"));
        } catch (Exception e) {
            log.error("ERROR: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, e.getMessage());
        }
        return Map.of("message", res);
    }
}
