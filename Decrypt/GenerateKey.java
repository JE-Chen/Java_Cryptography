package com.je_chen.Decrypt;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class GenerateKey {

    private KeyStore keyStore;
    private KeyStore.ProtectionParameter protectionParameter;
    private char[] password;

    public GenerateKey(String algorithm) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        keyStore = KeyStore.getInstance(algorithm);
        password = "changeit".toCharArray();
        String path = "C:/Program Files/Java/jdk-14.0.2/lib/security/cacerts";
        FileInputStream fileInputStream = new FileInputStream(path);
        keyStore.load(fileInputStream,password);
        protectionParameter = new KeyStore.PasswordProtection(password);
    }

    public void createKey(String secretPassword,String algorithm,String Alias,String keyStoreName) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        SecretKey secretKey = new SecretKeySpec(secretPassword.getBytes(),algorithm);
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
        keyStore.setEntry(Alias,secretKeyEntry,protectionParameter);
        this.outputKey(keyStoreName,password);
    }

    private void outputKey(String keyStoreName,char[] password) throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException {
        FileOutputStream fileOutputStream = new FileOutputStream(keyStoreName);
        keyStore.store(fileOutputStream,password);
    }
}
