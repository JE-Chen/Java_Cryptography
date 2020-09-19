package com.je_chen.Cryptography;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

public class Decrypting {

    private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;

    public Decrypting(String algorithm,int keySize) throws NoSuchAlgorithmException {
        this.init(algorithm, keySize);
    }

    public void init(String algorithm,int keySize) throws NoSuchAlgorithmException {
        keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        keyPairGenerator.initialize(keySize);
        keyPair = keyPairGenerator.generateKeyPair();
    }

    public byte[] decryptData(String data, String algorithm,PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE,publicKey);
        byte[] dataByte = data.getBytes();
        dataByte = Base64.getDecoder().decode(dataByte);
        cipher.update(dataByte);
        return cipher.doFinal();
    }

}
