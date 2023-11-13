package com.zayver.parcial.bridge.config;

import com.zayver.parcial.bridge.encrypt.IEncrypt;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IEncryptFactory {
    @Value("${parcial.encrypt}")
    private String encryptClass;
    @Bean
    public IEncrypt iEncrypt() throws Exception {
        val eClass = Class.forName(encryptClass);
        return (IEncrypt) eClass.getDeclaredConstructor().newInstance();
    }
}
