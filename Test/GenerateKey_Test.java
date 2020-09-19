package com.je_chen.Test;

import com.je_chen.Cryptography.GenerateKey;

public class GenerateKey_Test {
    public static void main(String[] args) {
        try {
            GenerateKey generateKey = new GenerateKey("JCEKS");
            generateKey.createKey("TestPassword","DSA","TestAlias","Test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
