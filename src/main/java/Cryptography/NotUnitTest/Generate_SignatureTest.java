package Cryptography.NotUnitTest;


import Cryptography.Module.GenerateSignature;

import java.nio.charset.StandardCharsets;
import java.security.*;

public class Generate_SignatureTest {

    public static void main(String[] args) {
        try {
            String message = "JE-Chen";
            GenerateSignature generateSignature = new GenerateSignature("DSA",2048);
            System.out.println(message);
            byte[] signature = generateSignature.createSignature(message,"SHA256withDSA");
            System.out.println(generateSignature.verifySignature(message,signature));
            System.out.println(new String(signature, StandardCharsets.UTF_8));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
