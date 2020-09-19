package com.je_chen.Cryptography;

import java.security.*;

public class GenerateSignature {

    private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;
    private Signature signature;

    public GenerateSignature(String algorithm,int keySize) throws NoSuchAlgorithmException {
        keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        keyPairGenerator.initialize(keySize);
        keyPair = keyPairGenerator.generateKeyPair();
    }

    public byte[] createSignature(String message,String algorithm) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        PrivateKey privateKey = keyPair.getPrivate();
        signature = Signature.getInstance(algorithm);
        signature.initSign(privateKey);
        byte[] messageByte = message.getBytes();
        signature.update(messageByte);
        return signature.sign();
    }

    public boolean verifySignature(String verifyMessage,byte[] verifySignature) throws SignatureException, InvalidKeyException {
        signature.initVerify(keyPair.getPublic());
        signature.update(verifyMessage.getBytes());
        return signature.verify(verifySignature);
    }

}
