package com.zayver.parcial.bridge.encrypt;

public class BridgeMessageEncryption implements IMessageEncrypt{

    private IEncrypt iEncrypt;
    @Override
    public String encrypt(String message, String password) throws Exception {
        return iEncrypt.encrypt(message, password);
    }
}
