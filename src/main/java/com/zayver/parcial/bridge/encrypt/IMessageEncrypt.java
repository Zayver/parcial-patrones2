package com.zayver.parcial.bridge.encrypt;

public interface IMessageEncrypt{
    String encrypt(String message, String password) throws Exception;
}
