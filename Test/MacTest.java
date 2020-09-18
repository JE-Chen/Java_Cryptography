package com.je_chen.Test;

import com.je_chen.Decrypt.GenerateMAC;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MacTest {

    public static void main(String[] argv){
        try {
            GenerateMAC generateMAC = new GenerateMAC("DES","HmacSHA256");
            System.out.println(generateMAC.computingMac("JE-Chen"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}
