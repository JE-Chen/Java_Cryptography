package com.je_chen.Test;

import com.je_chen.Decrypt.GenerateKey;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class GenerateKey_Test {
    public static void main(String[] args) {
        try {
            GenerateKey generateKey = new GenerateKey("JCEKS");
            generateKey.createKey("TestPassword","DSA","TestAlias");
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }
}
