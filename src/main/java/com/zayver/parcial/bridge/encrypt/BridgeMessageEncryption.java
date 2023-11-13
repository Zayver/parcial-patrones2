package com.zayver.parcial.bridge.encrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BridgeMessageEncryption implements IMessageEncrypt{

    @Autowired
    private IEncrypt iEncrypt;
    @Override
    public String encrypt(String message, String password) throws Exception {
        return iEncrypt.encrypt(message, password);
    }
}
