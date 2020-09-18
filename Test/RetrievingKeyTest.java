package com.je_chen.Test;

import com.je_chen.Encryption.RetrievingKey;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

public class RetrievingKeyTest {

    public static void main(String[] args) {
        try {
            RetrievingKey retrievingKey = new RetrievingKey("JCEKS");
            retrievingKey.CreateKey("TestPassword","DSA","TestAlias");
            for(String Detail : retrievingKey.Retrieving("Test")){
                System.out.println(Detail);
            }
        } catch (IOException | CertificateException | NoSuchAlgorithmException | KeyStoreException | UnrecoverableEntryException e) {
            e.printStackTrace();
        }
    }

}
