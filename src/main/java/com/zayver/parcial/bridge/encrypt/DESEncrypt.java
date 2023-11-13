package com.zayver.parcial.bridge.encrypt;

import lombok.val;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;

public class DESEncrypt implements IEncrypt{
    @Override
    public String encrypt(String message, String password) throws Exception {
        val dks = new DESKeySpec(message.getBytes());
        val skf = SecretKeyFactory.getInstance("DES");
        val desKey = skf.generateSecret(dks);
        val desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, desKey);
        val encoder = Base64.getEncoder();
        return encoder.encodeToString(desCipher.doFinal(message.getBytes()));
    }
}
