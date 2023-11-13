package com.zayver.parcial.bridge.encrypt;

public class NoEncrypt implements IEncrypt{
    @Override
    public String encrypt(String message, String password) {
        return message;
    }
}
