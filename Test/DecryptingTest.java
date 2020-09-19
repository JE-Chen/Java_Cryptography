package com.je_chen.Test;

import com.je_chen.Cryptography.Decrypting;
import com.je_chen.Cryptography.Encrypting;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DecryptingTest {

    public static void main(String[] argv){
        try {
            Encrypting encrypting = new Encrypting("RSA",2048);
            String encryptString = new String(encrypting.encryptData("JE-Chen","RSA/ECB/PKCS1Padding"), StandardCharsets.UTF_8);
            System.out.println(encryptString);
            Decrypting decrypting = new Decrypting("RSA",2048);
            System.out.println(new String(decrypting.decryptData(encryptString,"RSA/ECB/PKCS1Padding",encrypting.createPublicKey()), StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
    }

}
