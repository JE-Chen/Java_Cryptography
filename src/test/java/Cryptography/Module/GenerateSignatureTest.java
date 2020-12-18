package Cryptography.Module;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

class GenerateSignatureTest {

    @Test
    void testGenerateSignature(){
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