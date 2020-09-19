package com.je_chen.Test;

import com.je_chen.Cryptography.Decrypting;
import com.je_chen.Cryptography.Encrypting;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;


public class DecryptingTest {

    public static void main(String[] argv){
        try {
            Encrypting encrypting = new Encrypting("RSA",2048);
            String encryptString = new String(encrypting.encryptData("JE-Chen","RSA/ECB/PKCS1Padding"), StandardCharsets.UTF_8);
            System.out.println(encryptString);
            Decrypting decrypting = new Decrypting("RSA",2048);
            System.out.println(new String(decrypting.decryptData(encryptString,"RSA/ECB/PKCS1Padding",encrypting.getPublicKey()), StandardCharsets.UTF_8));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

}
