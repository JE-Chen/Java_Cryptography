package com.je_chen.Test;

import com.je_chen.Cryptography.GenerateMAC;

import java.security.GeneralSecurityException;

public class MacTest {

    public static void main(String[] argv){
        try {
            GenerateMAC generateMAC = new GenerateMAC("DES","HmacSHA256");
            System.out.println(generateMAC.computingMac("JE-Chen"));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
