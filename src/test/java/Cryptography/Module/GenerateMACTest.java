package Cryptography.Module;

import org.junit.jupiter.api.Test;

import java.security.GeneralSecurityException;

class GenerateMACTest {

    @Test
    void testGenerateMAC(){
        try {
            GenerateMAC generateMAC = new GenerateMAC("DES","HmacSHA256");
            System.out.println(generateMAC.computingMac("JE-Chen"));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

}